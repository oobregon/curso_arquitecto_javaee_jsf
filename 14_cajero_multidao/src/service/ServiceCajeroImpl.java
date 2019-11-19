package service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import dao.interfaces.DaoClientes;
import dao.interfaces.DaoCuentas;
import dao.interfaces.DaoMovimientos;
import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class ServiceCajeroImpl
 */
@Stateless
public class ServiceCajeroImpl implements ServiceCajero {

	@EJB (beanName = "DaoClientesImplHbt")
	DaoClientes daoClientes;	
	
	@EJB (beanName = "DaoCuentasImplHbt")
	DaoCuentas daoCuentas;
	
	@EJB (beanName = "DaoMovimientosImplHbt")
	DaoMovimientos daoMovimientos;
	
	@Override
	public Cuenta obtenerCuenta(int idCuenta) {
		return daoCuentas.findCuenta(idCuenta);
	}

	@Override
	public void extraccion(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		if(cuenta.getSaldo()>=cantidad) {
			cuenta.setSaldo(cuenta.getSaldo()-cantidad);
			daoCuentas.updateCuenta(cuenta);
			Movimiento m=new Movimiento(0,cantidad,new Date(),"extracción",cuenta);
			daoMovimientos.saveMovimiento(m);
		}else {
			throw new RuntimeException();
		}
		
	}
	@Override
	public void ingreso(int idCuenta, double cantidad) {
		Cuenta cuenta=obtenerCuenta(idCuenta);
		cuenta.setSaldo(cuenta.getSaldo()+cantidad);
		daoCuentas.updateCuenta(cuenta);
		Movimiento m=new Movimiento(0,cantidad,new Date(),"ingreso",cuenta);
		daoMovimientos.saveMovimiento(m);
	}
	@Override
	public void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad) {
		extraccion(idCuentaOrigen,cantidad);
		ingreso(idCuentaDestino,cantidad);
	}

	@Override
	public List<Cliente> obtenerTitulares(int idCuenta) {
		
		return daoClientes.findClienteByCuenta(idCuenta);
	}

	@Override
	public List<Movimiento> obtenerMovimientos(int idCuenta) {
		
		return daoMovimientos.findMovimientoByCuenta(idCuenta);
	}

	@Override
	public double obtenerSaldo(int idCuenta) {
		Cuenta cuenta=daoCuentas.findCuenta(idCuenta);
		return cuenta.getSaldo();
	}
}
