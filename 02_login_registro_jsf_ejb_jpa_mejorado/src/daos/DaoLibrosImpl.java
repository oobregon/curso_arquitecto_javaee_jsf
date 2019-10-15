package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import model.Libro;

/**
 * Session Bean implementation class DaoLibrosImpl
 */
@Stateless
public class DaoLibrosImpl implements DaoLibros {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Libro> obtenerLibros() {
		TypedQuery<Libro> q = em.createNamedQuery("todos",Libro.class);
		return q.getResultList();
	}
}
