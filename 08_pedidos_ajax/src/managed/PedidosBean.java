package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;

import daos.DaoPedidos;
import model.Pedido;

// Ya sabemos que en este caso no es necesario añadir la anotación @ManagedBean porque por defecto asigna
// el nombre de la clase empezando por minúscula
@ManagedBean(name = "pedidosBean")
@RequestScoped
public class PedidosBean {
	private List<Pedido> pedidos;
	private Pedido pedidoEditar;
	
	@EJB
	DaoPedidos pedEjb;
	
	@PostConstruct
	private void cargarPedidos() {
		this.setPedidos(pedEjb.damePedidos());		
	}
	
	public void eliminarPedido(int idPedido) {
		pedEjb.eliminarPedido(idPedido);
		setPedidos(pedEjb.damePedidos());		
	}
	
	public String editarPed(int idPedido) {
		setPedidoEditar(pedEjb.damePedido(idPedido));		
		return "editar";
	}
	
	public List<Pedido> getPedidos() {
		return this.pedidos;	
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Pedido getPedidoEditar() {
		return pedidoEditar;
	}

	public void setPedidoEditar(Pedido pedidoEditar) {
		this.pedidoEditar = pedidoEditar;
	}
}
