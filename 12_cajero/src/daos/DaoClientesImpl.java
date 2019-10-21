package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Cliente;
import model.Cuenta;

/**
 * Session Bean implementation class DaoClientesImpl
 */
@Stateless
public class DaoClientesImpl implements DaoClientes {
	@PersistenceContext(unitName = "cajeroUP")									
	EntityManager em;

	@Override
	public void altaCliente(Cliente cliente) {	
		em.persist(cliente);
	}

	@Override
	public List<Cliente> clientesDeCuenta(int numeroCuenta) {
		// Select c from Cliente c join c.cuentas t where t.numeroCuenta = ?1
		Cuenta cuenta = em.find(Cuenta.class,numeroCuenta);
		return cuenta.getClientes();
	}

	@Override
	public void eliminarCliente(int idCliente) {
		// ¿Borrado en cascada? Propagación de operaciones en cascada
		Cliente cliente = em.find(Cliente.class,idCliente);
		em.remove(cliente);		
	}

	@Override
	public List<Cliente> clienteConMovimientos(Date fecha) {
		String jpql = "select c from Cliente c join c.cuentas cu join cu.movimientos mov where mov.fecha = ?1";
		Query q = em.createQuery(jpql);
		q.setParameter(1,fecha);
		return (List<Cliente>)q.getResultList();
	}
}
