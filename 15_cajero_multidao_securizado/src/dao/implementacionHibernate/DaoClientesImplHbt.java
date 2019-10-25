package dao.implementacionHibernate;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;
import org.hibernate.Transaction;

import dao.interfaces.DaoClientes;
import dao.utilidades.HibernateUtil;
import model.Cliente;
import model.Cuenta;

/**
 * Session Bean implementation class DaoClientesImplHbt
 */
@Stateless
@LocalBean
public class DaoClientesImplHbt implements DaoClientes{	
	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Cuenta cuenta=sesion.get(Cuenta.class, idCuenta);
			if(cuenta!=null) {
				return cuenta.getClientes();
			}
		}
		return null;
	}

	@Override
	public void saveCliente(Cliente cliente) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Transaction tx = sesion.beginTransaction();
			sesion.save(cliente);
			tx.commit();				
		}
		
	}

	@Override
	public void updateCliente(Cliente cliente) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Transaction tx = sesion.beginTransaction();
			sesion.update(cliente);
			tx.commit();
		}
		
	}

	@Override
	public void removeCliente(int dni) {
		try(Session sesion=HibernateUtil.getSessionFactory().openSession();){
			Cliente cliente=sesion.get(Cliente.class, dni);			
			if(cliente!=null) {
				Transaction tx = sesion.beginTransaction();
				sesion.delete(cliente);
				tx.commit();				
			}
		}
		
	}   
}
