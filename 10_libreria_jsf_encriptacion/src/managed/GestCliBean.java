package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoClientes;
import model.Cliente;

@ManagedBean (name = "gestCliBean")
@RequestScoped
public class GestCliBean {
	List<Cliente> clientes;
	
	@EJB
	DaoClientes ejbCli;
	
	@PostConstruct
	private void inicio() {
		clientes = ejbCli.obtenerClientes();
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}
}
