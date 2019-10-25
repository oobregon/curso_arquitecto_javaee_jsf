package dao.implementacionhibernate;

import dao.interfaces.DaoMovimientos;
import dao.utilidades.HibernateUtil;
import model.Cuenta;
import model.Movimiento;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Session;

/**
 * Session Bean implementation class DaoMovimientosImplHb
 */
@Stateless
@Local(DaoMovimientos.class)
public class DaoMovimientosImplHb implements DaoMovimientos {

	@Override
	public List<Movimiento> findMovimientoByCuenta(int numCuenta) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			Cuenta cuenta = sesion.get(Cuenta.class,numCuenta);        	
        	if (cuenta != null) {
        		return cuenta.getMovimientos();
        	}
        }
		return null;
	}

	@Override
	public void saveMovimiento(Movimiento movimiento) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			sesion.save(movimiento);			
        }		
	}
}
