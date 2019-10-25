package dao.implementacionjpa;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dao.interfaces.DaoClientes;
import model.Cliente;
import model.Cuenta;

/**
 * Session Bean implementation class DaoClientesImpl
 */
@Stateless
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext(unitName = "UPcajero")
	EntityManager em;
	
	@Override
	public List<Cliente> findClienteByCuenta(int idCuenta) {
		Cuenta cuenta = em.find(Cuenta.class,idCuenta);
		if(cuenta != null) {
			return cuenta.getClientes();
		}
		return null;
	}

	@Override
	public void saveCliente(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	public void updateCliente(Cliente cliente) {		
		em.merge(cliente);
	}

	@Override
	public void removeCliente(int dni) {
		Cliente cliente = em.find(Cliente.class,dni);
		if (cliente != null) {
			em.remove(cliente);
		}
	}
}
