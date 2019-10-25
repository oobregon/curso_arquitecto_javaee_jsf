package service;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

@Local
public interface ServiceCajero {
	Cuenta obtenerCuenta(int idCuenta);
	void extraccion(int idCuenta, double cantidad);
	void ingreso(int idCuenta, double cantidad);
	void transferencia(int idCuentaOrigen, int idCuentaDestino, double cantidad);
	List<Cliente> obtenerTitulares(int idCuenta);
	List<Movimiento> obtenerMovimientos(int idCuenta);
	double obtenerSaldo(int idCuenta);
}
