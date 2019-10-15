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
	@EJB
	DaoLibros libEjb;
	
	private List<Libro> libros;
	
	@PostConstruct
	private void cargarLibros() {
		libros = libEjb.obtenerLibros();
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
}
