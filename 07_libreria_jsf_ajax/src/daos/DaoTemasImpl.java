package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Libro;
import model.Tema;

/**
 * Session Bean implementation class DaoTemasImpl
 */
@Stateless
public class DaoTemasImpl implements DaoTemas {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Tema> obtenerTemas() {
		TypedQuery<Tema> q = em.createNamedQuery("Tema.todos",Tema.class);
		return q.getResultList();
	}
}
