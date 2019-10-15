package managed;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import daos.DaoLibros;
import model.Libro;

@ManagedBean (name = "loginBean")
@RequestScoped
public class LoginBean {
	@EJB
	DaoClientes cliEjb;
	
	@EJB
	DaoLibros libEjb;
	
	private String usuario;
	private String contra;
	private List<Libro> libros;
	
	public List<Libro> getLibros() {
		return libros;
	}
	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContra() {
		return contra;
	}
	public void setContra(String contra) {
		this.contra = contra;
	}
	
	// Aquí introducimos lo que haríamos en el service de nuestros antiguos servlets.
	// ¿qué es lo que devolvía nuestro frontcontroler? Un nombre de vista.
	// Pues bien, este método nuestro login tiene que devolver un nombre de vista.
	public String login() {		
		if (cliEjb.existe(getUsuario(),getContra())) {
			libros = libEjb.obtenerLibros();
			return "bienvenida";
		} else {
			return "nologin";
		}
	}
}
