package managed;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean (name = "registroBean")
@RequestScoped
public class RegistroBean {		
	Cliente cliente;
	private String repContra;
	
	@EJB
	DaoClientes cliEjb;	
	
	public RegistroBean() {
		cliente = new Cliente();
	}
	
	public String confirmar() {
		//Cliente cli = new Cliente(0,cliente.getEmail(),cliente.getPassword(),cliente.getTelefono(),cliente.getUsuario());				
		cliEjb.registrar(cliente);
		return "login";
	}	
	
	public String registrar() {		
		return "registro";
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getRepContra() {
		return repContra;
	}

	public void setRepContra(String repContra) {
		this.repContra = repContra;
	}
}
