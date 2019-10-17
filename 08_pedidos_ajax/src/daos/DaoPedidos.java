package daos;

import java.util.List;

import javax.ejb.Local;

import model.Pedido;

@Local
public interface DaoPedidos {
	
	List<Pedido> damePedidos();
	
	List<String> dameCategorias();	
	
	Pedido damePedido(int idPedido);

	void altaPedido(Pedido pedido);

	void eliminarPedido(int idPedido);
	
	void modificarPedido(Pedido pedido);
}
