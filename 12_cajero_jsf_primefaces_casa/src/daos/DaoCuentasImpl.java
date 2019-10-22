package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Cliente;
import model.Cuenta;

/**
 * Session Bean implementation class DaoCuentasImpl
 */
@Stateless
public class DaoCuentasImpl implements DaoCuentas {
	@PersistenceContext(unitName = "bancoUP")									
	EntityManager em;

	@Override
	public void altaCuenta(Cuenta cuenta) {
		em.persist(cuenta);
	}

	@Override
	public List<Cuenta> cuentasDeCliente(int idCliente) {
		Cliente cliente = em.find(Cliente.class,idCliente);
		return cliente.getCuentas();
	}

	@Override
	public void eliminarCuenta(int numCuenta) {
		em.remove(this.obtenerCuenta(numCuenta));		
	}

	@Override
	public Cuenta obtenerCuenta(int numCuenta) {
		return em.find(Cuenta.class,numCuenta);
	}

	@Override
	public List<Cuenta> obtenerCuentas() {
		TypedQuery<Cuenta> q = em.createNamedQuery("Cuenta.findAll",Cuenta.class);
		return q.getResultList();		
	}
}
