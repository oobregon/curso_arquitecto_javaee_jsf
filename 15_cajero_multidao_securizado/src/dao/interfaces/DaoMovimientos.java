package dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Movimiento;

@Local
public interface DaoMovimientos {
	List<Movimiento> findMovimientoByCuenta(int idCuenta);
	void saveMovimiento(Movimiento m);
}
