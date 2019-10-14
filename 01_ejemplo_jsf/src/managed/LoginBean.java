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
	
	// Aqu� introducimos lo que har�amos en el service de nuestros antiguos servlets.
	// �qu� es lo que devolv�a nuestro frontcontroler? Un nombre de vista.
	// Pues bien, este m�todo nuestro login, tiene que devolver un nombre de vista.
	public String login() {
		if(usuario.equals("curso") && contra.equals("curso")) {
			return "bienvenida";
		} else {
			return "nologin";
		}
	}	
}
