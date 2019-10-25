package dao.implementacionhibernate;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.hibernate.Session;

import dao.interfaces.DaoClientes;
import dao.utilidades.HibernateUtil;
import model.Cliente;
import model.Cuenta;

/**
 * Session Bean implementation class DaoClientesImplHb
 */
@Stateless
@Local(DaoClientes.class)
public class DaoClientesImplHb implements DaoClientes {
	static Session sesion;
	static {
		sesion = HibernateUtil.getSessionFactory().openSession();
	}
	
	// Incluimos el try catch con recursos solamente para que se cierre la sesion automáticamente, no para
	// capturar las excepciones.
	// Este objeto org.hibernate.Session consume muuuuchos recurso, por eso, 
	@Override
	public void saveCliente(Cliente cliente) {
        try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
        	sesion.save(cliente);
        }
    }

	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
			Cuenta cuenta = sesion.get(Cuenta.class,idCuenta);        	
        	if (cuenta != null) {
        		return cuenta.getClientes();
        	}
        }
		return null;
    }

	@Override
	public void updateCliente(Cliente cliente) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
        	sesion.update(cliente);        	
        }
    }

	@Override
	public void removeCliente(int dni) {
		try (Session sesion = HibernateUtil.getSessionFactory().openSession()) {
        	Cliente cliente = sesion.get(Cliente.class,dni);
        	if (cliente != null) {
        		sesion.delete(cliente);
        	}
        } 
    }

}
