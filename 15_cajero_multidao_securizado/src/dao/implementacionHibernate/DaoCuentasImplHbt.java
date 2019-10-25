package dao.implementacionHibernate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import dao.interfaces.DaoCuentas;
import dao.utilidades.HibernateUtil;
import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentasImplHbt
 */
@Stateless
@LocalBean
public class DaoCuentasImplHbt implements DaoCuentas{

	@Override
	public Cuenta findCuenta(int numeroCuenta) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Cuenta cuenta=sesion.get(Cuenta.class, numeroCuenta);
			return cuenta;
		}
	}

	@Override
	public List<Cuenta> findAllCuenta() {
		String hql="Select c From Cuenta c";
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Query<Cuenta> query=sesion.createQuery(hql, Cuenta.class);
			return query.list();
		}
	}

	@Override
	public void updateCuenta(Cuenta cuenta) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Transaction tx = sesion.beginTransaction();
			sesion.update(cuenta);
			tx.commit();			
		}	
	}
}
