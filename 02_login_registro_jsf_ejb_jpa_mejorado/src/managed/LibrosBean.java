package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

// No sería necesario añada la anotación (name = "librosBean"), ya que, por defecto así se crearía
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	// Por propia definición, la inyección de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado. Durante la creación de LibrosBean no se puede hacer inyección de dependencias
	// porque todavía no existe el objeto que va a recibir la inyección.
	// Por regla general, la mejor solución a este problema es la anotación @PostConstruct 
	@EJB
	DaoLibros libEjb;
	
	private List<Libro> libros;
	
	public LibrosBean() {
		// No se puede hacer inyección de dependencias en un constructor 
		// libros = libEjb.obtenerLibros();
	}
	
	@PostConstruct
	private void cargaLibros() {
		libros = libEjb.obtenerLibros();
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
