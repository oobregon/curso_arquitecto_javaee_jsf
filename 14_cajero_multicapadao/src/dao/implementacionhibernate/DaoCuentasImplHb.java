package dao.implementacionhibernate;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.query.Query;

import dao.utilidades.HibernateUtil;
import model.Cuenta;
import model.DaoCuentas;

/**
 * Session Bean implementation class DaoCuentasImplHb
 */
@Stateless
@Local(DaoCuentas.class)
public class DaoCuentasImplHb implements DaoCuentas {

	/**
     * @see DaoCuentas#findCuenta(int)
     */
	@Override
    public Cuenta findCuenta(int numCuenta) {
    	try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			Cuenta cuenta = sesion.get(Cuenta.class,numCuenta);        	
			return cuenta;
        }		
    }

	/**
     * @see DaoCuentas#updateCuenta(Cuenta)
     */
	@Override
    public void updateCuenta(Cuenta cuenta) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
        	sesion.update(cuenta);
        }
    }

	/**
     * @see DaoCuentas#findAllCuenta()
     */
	@Override
    public List<Cuenta> findAllCuenta() {
        String hql = "Select c from Cuenta c";
        try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
        	Query<Cuenta> q = sesion.createQuery(hql,Cuenta.class);
			return q.list();
        }
    }
}
