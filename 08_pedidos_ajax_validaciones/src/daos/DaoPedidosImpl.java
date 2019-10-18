package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Pedido;

/**
 * Session Bean implementation class DaoPedidosImpl
 */
@Stateless
public class DaoPedidosImpl implements DaoPedidos {
	@PersistenceContext(unitName = "UPPedidos")
	EntityManager em;
	
	@Override
	public List<Pedido> damePedidos() {
		String jpql = "select p from Pedido p";
		Query q = em.createQuery(jpql);
		return (List<Pedido>)q.getResultList();
	}
	
	private List<Pedido> damePedidosConNamedQueries() {		
		Query q = em.createNamedQuery("Pedido.findAll");
		return (List<Pedido>)q.getResultList();
	}

	@Override
	public Pedido damePedido(int idPedido) {
		// el find hace búsqueda por clave primaria
		Pedido pedido = em.find(Pedido.class,idPedido);				
		return pedido;
	}

	@Override
	public void altaPedido(Pedido pedido) {
		// El persist puede lanzar excepciones, pero como son excepciones runtime, no es necesario controlarlas
		em.persist(pedido);
	}

	@Override
	public void eliminarPedido(int idPedido) {
		em.remove(damePedido(idPedido));
	}

	@Override
	public void modificarPedido(Pedido pedido) {
		em.merge(pedido);		
	}

	@Override
	public List<String> dameCategorias() {
		String jpql = "select distinct(p.categoria) from Pedido p";
		Query q = em.createQuery(jpql);
		return (List<String>)q.getResultList();
	}
}
