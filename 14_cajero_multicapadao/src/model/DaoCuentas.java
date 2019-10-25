package model;

import java.util.List;

import javax.ejb.Local;

@Local
public interface DaoCuentas {
	Cuenta findCuenta(int numCuenta);
	List<Cuenta> findAllCuenta();
	void updateCuenta(Cuenta cuenta);
}