package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import daos.DaoClientes;
import daos.DaoLibros;
import model.Cliente;

@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean {
	private String usuario;
	private String contra;
	private Cliente cliLogado;
	
	@EJB
	DaoClientes cliEjb;
	
	@EJB
	DaoLibros libEjb;
	
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
	
	public Cliente getCliLogado() {
		return cliLogado;
	}
	public void setCliLogado(Cliente cliLogado) {
		this.cliLogado = cliLogado;
	}
	// Aqu� introducimos lo que har�amos en el service de nuestros antiguos servlets.
	// �qu� es lo que devolv�a nuestro frontcontroler? Un nombre de vista.
	// Pues bien, este m�todo nuestro login, tiene que devolver un nombre de vista.
	public String login() {	
		Cliente cli = cliEjb.obtenerCliente(getUsuario(),getContra());
		if (cli.getUsuario().equals(getUsuario()) && cli.getPassword().equals(getContra())) {
			this.setCliLogado(cli);
			return "menu";
		} else {
			return "nologin";
		}
	}
}
