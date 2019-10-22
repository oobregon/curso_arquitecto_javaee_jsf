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
	// La capa de servicio no (no jdbc, no jpa)
	
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
	public void extraccion(int numCuenta, double cantidad) {
		Cuenta cuenta = ejbCuentas.findCuenta(numCuenta);
		if(cuenta.getSaldo() >= cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			ejbCuentas.updateCuenta(cuenta);
			Movimiento mov = new Movimiento(0,cantidad,new Date(),"Extracción",cuenta);
			ejbMov.saveMovimiento(mov);
		}		
	}

	@Override
	public void ingreso(int numCuenta, double cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void transferencia(int numCuentaOrigen, int numCuentaDestino, double cantidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int numCuenta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double obtenerSaldo(int numCuenta) {
		// TODO Auto-generated method stub
		return 0;
	}

}
