package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

// No ser�a necesario a�ada la anotaci�n (name = "librosBean"), ya que, por defecto as� se crear�a
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	// Por propia definici�n, la inyecci�n de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado. Durante la creaci�n de LibrosBean no se puede hacer inyecci�n de dependencias
	// porque todav�a no existe el objeto que va a recibir la inyecci�n.
	// Por regla general, la mejor soluci�n a este problema es la anotaci�n @PostConstruct 
	@EJB
	DaoLibros libEjb;
	
	private List<Libro> libros;
	
	public LibrosBean() {
		// No se puede hacer inyecci�n de dependencias en un constructor 
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
