package dao.implementacionHibernate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.DaoMovimientos;
import dao.utilidades.HibernateUtil;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosImplHbt
 */
@Stateless
@LocalBean
public class DaoMovimientosImplHbt implements DaoMovimientos{

	@Override
	public List<Movimiento> findMovimientoByCuenta(int idCuenta) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Cuenta cuenta=sesion.get(Cuenta.class, idCuenta);
			if(cuenta!=null) {
				return cuenta.getMovimientos();
			}
		}
		return null;
	}

	@Override
	public void saveMovimiento(Movimiento m) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession()){
			Transaction tx = sesion.beginTransaction();
			sesion.save(m);
			tx.commit();
		}	
	}
   
}
