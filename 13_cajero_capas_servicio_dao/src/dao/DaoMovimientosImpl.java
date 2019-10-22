package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosImpl
 */
@Stateless
public class DaoMovimientosImpl implements DaoMovimientos {
	@PersistenceContext(unitName = "UPcajero")
	EntityManager em;

	@Override
	public List<Movimiento> findMovimientoByCuenta(int numCuenta) {
		Cuenta cuenta = em.find(Cuenta.class,numCuenta);
		if (cuenta != null) {
			return cuenta.getMovimientos();
		}
		return null;
	}

	@Override
	public void saveMovimiento(Movimiento movimiento) {
		em.persist(movimiento);
	}
}
