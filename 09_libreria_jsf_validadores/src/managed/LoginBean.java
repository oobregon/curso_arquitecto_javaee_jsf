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
	// Aquí introducimos lo que haríamos en el service de nuestros antiguos servlets.
	// ¿qué es lo que devolvía nuestro frontcontroler? Un nombre de vista.
	// Pues bien, este método nuestro login, tiene que devolver un nombre de vista.
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
