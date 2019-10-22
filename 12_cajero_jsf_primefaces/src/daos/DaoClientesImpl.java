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
	@PersistenceContext(unitName = "bancoUP")									
	EntityManager em;

	@Override
	public void altaCliente(Cliente cliente) {
		em.persist(cliente);
	}

	@Override
	public List<Cliente> clientesDeCuenta(int numeroCuenta) {
		Cuenta cuenta = em.find(Cuenta.class,numeroCuenta);
		return cuenta.getClientes();
	}

	@Override
	public void eliminarCliente(int idCliente) {
		em.remove(this.obtenerCliente(idCliente));
	}

	@Override
	public List<Cliente> clienteConMovimientos(Date fecha) {
		String jpql = "select c from Cliente c join c.cuentas cu join cu.movimientos mov where mov.fecha = ?1";
		Query q = em.createQuery(jpql);
		q.setParameter(1,fecha);
		return (List<Cliente>)q.getResultList();
	}

	@Override
	public Cliente obtenerCliente(int idCliente) {
		return em.find(Cliente.class,idCliente);
	}

	@Override
	public List<Cliente> obtenerClientes() {
		Query q = em.createNamedQuery("todos");
    	return (List<Cliente>)q.getResultList(); 
	}
}
