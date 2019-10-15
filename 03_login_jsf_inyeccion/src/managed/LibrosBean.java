package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoLibros;
import model.Libro;

// No ser�a necesario a�ada la anotaci�n (name = "librosBean"), ya que, por defecto se crear�a con ese nombre, 
// es decir, el nombre de la clase pero empezando por min�scula
@ManagedBean(name = "librosBean")
@RequestScoped
public class LibrosBean {
	// Por propia definici�n, la inyecci�n de dependencia es que inyectamos un objeto (EJB) en otro (LibrosBean), pero claro,
	// LibrosBean ya tiene que estar creado; sino est� creado el LibrosBean, entonces �D�nde inyectas el EJB?
	// Durante la creaci�n de LibrosBean no se puede hacer inyecci�n de dependencias porque todav�a no existe el objeto que va a recibir la inyecci�n.
	// Por regla general, la mejor soluci�n a este problema es la anotaci�n @PostConstruct 
	@EJB
	DaoLibros libEjb;
	
	// Podemos inyectar el loginBean porque su �mbito es de sesi�n, si su �mbito fuera de petici�n, en este punto no podr�amos 
	// inyectar dicho managedBean porque ya no existir�a
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;

	private List<Libro> libros;
	
	public LibrosBean() {
		// No se puede hacer inyecci�n de dependencias en un constructor 
		// libros = libEjb.obtenerLibros();
	}
	
	// Esta anotaci�n nos garantiza que el m�todo que la sigue se va a ejecutar solamente cuando la instancia (this) est� creada.
	@PostConstruct
	private void cargaLibros() {
		libros = libEjb.obtenerLibros();
		if(loginBean.getUsuario().equals("test1")) {
			libros = libEjb.obtenerLibrosPorTema(1);
		} else {
			libros = libEjb.obtenerLibros();
		}
	}

	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
}
