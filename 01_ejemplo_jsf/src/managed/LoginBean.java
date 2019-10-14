package managed;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name = "loginBean")
@RequestScoped
public class LoginBean {
	private String usuario;
	private String contra;
	
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
	// Pues bien, este método nuestro login, tiene que devolver un nombre de vista.
	public String login() {
		if(usuario.equals("curso") && contra.equals("curso")) {
			return "bienvenida";
		} else {
			return "nologin";
		}
	}	
}
