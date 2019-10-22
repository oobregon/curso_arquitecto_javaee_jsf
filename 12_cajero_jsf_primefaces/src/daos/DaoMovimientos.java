package daos;

import java.util.List;

import javax.ejb.Local;

import managed.IntervaloFechas;
import model.Movimiento;

@Local
public interface DaoMovimientos {
	void altaMovimiento(Movimiento movimiento);
	void eliminarMovimiento(int idMovimiento);
	List<Movimiento> movimientosCuenta(int numCuenta);
	List<Movimiento> movimientosCuenta(int numCuenta,IntervaloFechas intervalo);
	List<Movimiento> movimientosCliente(int idCliente);	
	Movimiento obtenerMovimiento(int idMovimiento);
}
