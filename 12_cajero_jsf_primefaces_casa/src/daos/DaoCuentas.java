package daos;

import java.util.List;

import javax.ejb.Local;

import model.Cuenta;

@Local
public interface DaoCuentas {
	void altaCuenta(Cuenta cuenta);
	List<Cuenta> cuentasDeCliente(int idCliente);
	List<Cuenta> obtenerCuentas();
	void eliminarCuenta(int numCuenta);	
	Cuenta obtenerCuenta(int numCuenta);
}
