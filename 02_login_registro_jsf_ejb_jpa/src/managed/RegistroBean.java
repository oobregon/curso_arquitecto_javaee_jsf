package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean (name = "registroBean")
@RequestScoped
public class RegistroBean {
	@EJB
	DaoClientes cliEjb;
	
	private String usuario;
	private String contra;
	private String email;
	private String tfno;
	
	public DaoClientes getCliEjb() {
		return cliEjb;
	}
	public void setCliEjb(DaoClientes cliEjb) {
		this.cliEjb = cliEjb;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTfno() {
		return tfno;
	}
	public void setTfno(String tfno) {
		this.tfno = tfno;
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
	
	public String confirmar() {
		Cliente cliente = new Cliente(0,getEmail(),getContra(),Integer.parseInt(getTfno()),getUsuario());		
		cliEjb.registrar(cliente);
		return "login";
	}	
	
	public String registrar() {		
		return "registro";
	}
}
