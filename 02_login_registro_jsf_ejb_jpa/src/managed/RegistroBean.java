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
	
	Cliente cliente;
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String confirmar() {
		Cliente cli = new Cliente(0,cliente.getEmail(),cliente.getPassword(),cliente.getTelefono(),cliente.getUsuario());				
		cliEjb.registrar(cli);
		return "login";
	}	
	
	public String registrar() {		
		return "registro";
	}
}
