package managed;

import java.util.List;

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
	// Durante la creación de LibrosBean no se puede hacer inyección de dependencias porque todavía no existe el objeto que va 
	// a recibir la inyección. Por regla general, la mejor solución a este problema es anotar un método de la Clase
	// como @PostConstruct, y esto nos garantiza que el código de dicho método ya podrá contar con la instancia de la Clase,
	// en este caso, LibrosBean. 
	@EJB
	DaoLibros libEjb;
	
	// Inyectamos este managedbean porque, aun siendo su ámbito el de petición, sabemos que la petición que llega viene de
	// temas, por lo tanto, los parámetros de petición están disponibles en el managedbean. Si la petición que llega aquí viniera
	// del algo que no fuera temas, entonces no tendríamos acceso al temasBean, a no ser que cambiáramos su ámbito de 
	// petición a sesión.	
	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;	

	// @PostConstruct
	// Este método ya no puede ser postconstruct porque cuando se ejecute todavía no se han copiado los nuevos
	// valores del forumulario a los managedbean (ejecución de setters de la fase 4.- UPDATE MODEL VALUE), por lo tanto,
	// en este caso concreto, el temasBean.getIdTema() no devolverá el idTema seleccionado en el formulario porque
	// todavía no se ha ejecutado el temasBean.setIdTema(compxHtmlDelArbol) de la fase 4
	private void cargaLibros() {		
		int idTema = temasBean.getIdTema();
		libros = idTema==0?libEjb.obtenerLibros():libEjb.obtenerLibrosPorTema(idTema);		
	}

	public List<Libro> getLibros() {
		// Ya no podemos cargar los libros en un método postconstruct porque éste se ejecuta en la fase 1.- RESTOREVIEW, 
		// es decir, todavía los mb no tienen disponible el idTema seleccionado. El idTema es
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
		ContextoApp.obtenerSesion().invalidate();		
		return "login";
	}
}
