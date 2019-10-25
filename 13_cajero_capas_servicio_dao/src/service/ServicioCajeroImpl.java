package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.DaoClientes;
import dao.DaoCuentas;
import dao.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class ServicioCajeroImpl
 */
@Stateless
public class ServicioCajeroImpl implements ServicioCajero {
	// La capa de servicio no debe contener ninguna sentencia de acceso a datos, ninguna sentencia
	// de persistencia (no jdbc, no jpa, no ds). La capa que conoce acceso a datos es la capa Dao.
	// Inyectar interfaces EJB de negocio no son sentencias de acceso a datos. 
	
	// Viendo esta capa de servicio no debemos ver ning�n v�nculo a tecnolog�as de acceso a 
	// datos. La inyecci�n de EJB,s es independiente de la tecnolog�a de acceso a datos (jpa,
	// jdbc,etc); si se cambia la tecnolog�a de acceso a datos, esta capa de servicio no se ve
	// alterada de forma alguna, la inyecci�n de dependencias seguir�a siendo tal y como es ahora.
	
	@EJB
	DaoClientes ejbCli;
	
	@EJB
	DaoCuentas ejbCuentas;
	
	@EJB
	DaoMovimientos ejbMov;

	@Override
	public Cuenta obtenerCuenta(int numCuenta) {
		return ejbCuentas.findCuenta(numCuenta);
	}

	@Override
	public void extraer(int numCuenta, double cantidad) {
		Cuenta cuenta = ejbCuentas.findCuenta(numCuenta);
		if(cuenta.getSaldo() >= cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			ejbCuentas.updateCuenta(cuenta);
			Movimiento mov = new Movimiento(0,cantidad,new Date(),"Extracci�n",cuenta);
			ejbMov.saveMovimiento(mov);
		} else {
			throw new RuntimeException();
		}
	}

	@Override
	public void ingresar(int numCuenta, double cantidad) {
		Cuenta cuenta = ejbCuentas.findCuenta(numCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		ejbCuentas.updateCuenta(cuenta);
		Movimiento movimiento = new Movimiento(0,cantidad,new Date(),"Ingreso",cuenta);
		ejbMov.saveMovimiento(movimiento);
	}

	@Override
	public void transferir(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		this.extraer(numCuentaOrigen,cantidad);
		this.ingresar(numCuentaDestino,cantidad);
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		return ejbCli.findClienteByCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int numCuenta) {
		return ejbMov.findMovimientoByCuenta(numCuenta);
	}

	@Override
	public double obtenerSaldo(int numCuenta) {
		return ejbCuentas.findCuenta(numCuenta).getSaldo();
	}
}
