package managed;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;

@ManagedBean(name = "altaBean")
@RequestScoped
public class AltaBean {
	private Pedido pedido;
	
	@EJB
	DaoPedidos pedEjb;
	
	@PostConstruct
	private void inicio() {
		setPedido(new Pedido());
	}
	
	public String confirmar() {
		pedEjb.altaPedido(getPedido());
		return "menu";
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
}
