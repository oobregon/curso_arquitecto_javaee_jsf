package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;

// Ya sabemos que en este caso no es necesario añadir la anotación @ManagedBean porque por defecto asigna
// el nombre de la clase empezando por minúscula
@ManagedBean(name = "pedidosBean")
@RequestScoped
public class PedidosBean {
	private List<Pedido> pedidos;
	private int idPedido;
	
	@EJB
	DaoPedidos pedEjb;
	
	public List<Pedido> getPedidos() {
		return this.pedidos;	
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	@PostConstruct
	private void cargarPedidos() {
		this.setPedidos(pedEjb.damePedidos());		
	}
	
	public void eliminarPedido(int idPedido) {
		pedEjb.eliminarPedido(idPedido);	
		pedidos = pedEjb.damePedidos();
	}
	
	public String editarPed(int idPedido) {
		setIdPedido(idPedido);
		return "editar";
	}
}
