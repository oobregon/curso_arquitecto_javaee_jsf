package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;

@ManagedBean (name = "loginBean")
@RequestScoped
public class LoginBean {
	@EJB
	DaoClientes cliEjb;
	
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
		if (cliEjb.existe(getUsuario(),getContra())) {
			return "bienvenida";
		} else {
			return "nologin";
		}
	}
}
