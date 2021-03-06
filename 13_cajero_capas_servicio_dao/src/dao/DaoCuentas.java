package dao;

import java.util.List;

import javax.ejb.Local;

import model.Cuenta;

@Local
public interface DaoCuentas {
	Cuenta findCuenta(int numCuenta);
	List<Cuenta> findAllCuenta();
	void updateCuenta(Cuenta cuenta);
}
