package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoPedidos;
import model.Pedido;

@ManagedBean(name = "editarPedBean")
@RequestScoped
public class EditarPedBean {
	private int idPedido;
	private Pedido pedido;
	private List<String> categorias;
	private String categoria;
	
	
	@EJB
	DaoPedidos pedEjb;
	
	@ManagedProperty("#{pedidosBean}")
	PedidosBean pedidosBean;
	
	@PostConstruct
	private void cargarCategorias() {
		categorias = pedEjb.dameCategorias();
		idPedido = idPedido!=0?idPedido:pedidosBean.getIdPedido();
		pedido = pedEjb.damePedido(idPedido);
		categoria = pedido.getCategoria();
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public List<String> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<String> categorias) {
		this.categorias = categorias;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public PedidosBean getPedidosBean() {
		return pedidosBean;
	}

	public void setPedidosBean(PedidosBean pedidosBean) {
		this.pedidosBean = pedidosBean;
	}

	public String guardar() {
		pedido.setCategoria(categoria);
		pedEjb.modificarPedido(pedido);
		return "pedidos";
	}	
}
