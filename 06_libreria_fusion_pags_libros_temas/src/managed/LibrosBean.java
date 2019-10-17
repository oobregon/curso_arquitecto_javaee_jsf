package managed;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;
import utilidades.ContextoApp;

// No ser�a necesario a�ada la anotaci�n (name = "librosBean"), ya que, por defecto se crear�a con ese nombre, 
// es decir, el nombre de la clase pero empezando por min�scula
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	private List<Libro> libros;
	
	// Por propia definici�n, la inyecci�n de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado; sino est� creado el LibrosBean, entonces �D�nde inyectas el EJB?
	// Durante la creaci�n de LibrosBean no se puede hacer inyecci�n de dependencias porque todav�a no existe el objeto que va 
	// a recibir la inyecci�n. Por regla general, la mejor soluci�n a este problema es anotar un m�todo de la Clase
	// como @PostConstruct, y esto nos garantiza que el c�digo de dicho m�todo ya podr� contar con la instancia de la Clase,
	// en este caso, LibrosBean. 
	@EJB
	DaoLibros libEjb;
	
	// Inyectamos este managedbean porque, aun siendo su �mbito el de petici�n, sabemos que la petici�n que llega viene de
	// temas, por lo tanto, los par�metros de petici�n est�n disponibles en el managedbean. Si la petici�n que llega aqu� viniera
	// del algo que no fuera temas, entonces no tendr�amos acceso al temasBean, a no ser que cambi�ramos su �mbito de 
	// petici�n a sesi�n.	
	@ManagedProperty("#{temasBean}")
	TemasBean temasBean;	

	// @PostConstruct
	// Este m�todo ya no puede ser postconstruct porque cuando se ejecute todav�a no se han copiado los nuevos
	// valores del forumulario a los managedbean (ejecuci�n de setters de la fase 4.- UPDATE MODEL VALUE), por lo tanto,
	// en este caso concreto, el temasBean.getIdTema() no devolver� el idTema seleccionado en el formulario porque
	// todav�a no se ha ejecutado el temasBean.setIdTema(compxHtmlDelArbol) de la fase 4
	private void cargaLibros() {		
		int idTema = temasBean.getIdTema();
		libros = idTema==0?libEjb.obtenerLibros():libEjb.obtenerLibrosPorTema(idTema);		
	}

	public List<Libro> getLibros() {
		// Ya no podemos cargar los libros en un m�todo postconstruct porque �ste se ejecuta en la fase 1.- RESTOREVIEW, 
		// es decir, todav�a los mb no tienen disponible el idTema seleccionado. El idTema es
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
