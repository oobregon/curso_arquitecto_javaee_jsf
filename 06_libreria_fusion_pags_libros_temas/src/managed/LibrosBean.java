package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;
import utilidades.ContextoApp;

// No sería necesario añada la anotación (name = "librosBean"), ya que, por defecto se crearía con ese nombre, 
// es decir, el nombre de la clase pero empezando por minúscula
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	private List<Libro> libros;
	
	// Por propia definición, la inyección de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado; sino está creado el LibrosBean, entonces ¿Dónde inyectas el EJB?
	// Durante la creación de LibrosBean no se puede hacer inyección de dependencias porque todavía no existe el objeto que va a recibir la inyección.
	// Por regla general, la mejor solución a este problema es la anotación @PostConstruct 
	@EJB
	DaoLibros libEjb;
	
	// Podemos inyectar el loginBean porque su ámbito es de sesión, si su ámbito fuera de petición, en este punto no podríamos 
	// inyectar dicho managedBean porque ya no existiría
	
	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;	
	
	public LibrosBean() {}

	private void cargaLibros() {		
		int idTema = temasBean.getIdTema();
		libros = idTema==0?libEjb.obtenerLibros():libEjb.obtenerLibrosPorTema(idTema);		
	}

	public List<Libro> getLibros() {
		// Ya no podemos cargar los libros en un método postconstruct porque éste se ejecuta en la fase 1.- RESTOREVIEW, es decir, todavía
		// los mb no tienen disponible el idTema seleccionado. El idTema es
		this.cargaLibros();
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	public TemasBean getTemasBean() {
		return temasBean;
	}

	public void setTemasBean(TemasBean temasBean) {
		this.temasBean = temasBean;
	}
	
	public String cerrarSesion() {		
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ContextoApp.obtenerSesion().invalidate();
		return "login";
	}
}
