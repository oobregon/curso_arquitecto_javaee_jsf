package daos;

import java.util.List;

import javax.ejb.Local;

import model.Venta;

@Local
public interface DaoVentas {
	public List<Venta> obtenerVentasCliente(int idCliente);
	public List<Venta> obtenerVentasLibro(int isbn);
}
