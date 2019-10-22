package service;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

@Local
public interface ServicioCajero {
	Cuenta obtenerCuenta(int numCuenta);
	void extraccion(int numCuenta,double cantidad);
	void ingreso(int numCuenta,double cantidad);
	void transferencia(int numCuentaOrigen,int numCuentaDestino,double cantidad);
	List<Cliente> obtenerTitulares(int idCuenta);
	List<Movimiento> obtenerMovimientos(int numCuenta);
	double obtenerSaldo(int numCuenta);
}
