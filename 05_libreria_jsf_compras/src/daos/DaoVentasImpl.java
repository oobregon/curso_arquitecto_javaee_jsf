package daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cliente;
import model.Libro;
import model.Venta;

/**
 * Session Bean implementation class DaoVentasImpl
 */
@Stateless
public class DaoVentasImpl implements DaoVentas {
	@PersistenceContext(unitName = "librosUP")
	EntityManager em;

	@Override
	public List<Venta> obtenerVentasCliente(int idCliente) {
		Cliente cliente = em.find(Cliente.class,idCliente);
		List<Venta> ventas = cliente.getVentas();
		return ventas;
	}

	@Override
	public List<Venta> obtenerVentasLibro(int isbn) {
		Libro libro = em.find(Libro.class,isbn);
		List<Venta> ventas = libro.getVentas();
		return ventas;		
	}
}

