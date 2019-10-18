package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import daos.DaoPedidos;
import model.Pedido;

@ManagedBean(name = "editarPedBean")
@ViewScoped
public class EditarPedBean {
	private Pedido pedidoEditado;
	private List<String> categorias;
	private String categoria;
		
	@EJB
	DaoPedidos pedEjb;
	
	@ManagedProperty("#{pedidosBean!=null?pedidosBean:null}")	
	PedidosBean pedidosBean;
	
	@PostConstruct
	private void inicio() throws InterruptedException {		
		setCategorias(pedEjb.dameCategorias());
		//Thread.sleep(5000);
		setPedidoEditado(getPedidosBean().getPedidoEditar());
	}
	
	public String guardar() {
		pedEjb.modificarPedido(getPedidoEditado());
		return "pedidos";
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

	public Pedido getPedidoEditado() {
		return pedidoEditado;
	}

	public void setPedidoEditado(Pedido pedidoEditado) {
		this.pedidoEditado = pedidoEditado;
	}

	public PedidosBean getPedidosBean() {
		return pedidosBean;
	}

	public void setPedidosBean(PedidosBean pedidosBean) {
		this.pedidosBean = pedidosBean;
	}
}
