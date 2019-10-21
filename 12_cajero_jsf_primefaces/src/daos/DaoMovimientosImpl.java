package daos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Cliente;
import model.Cuenta;
import model.Movimiento;

/**
 * Session Bean implementation class DaoMovimientosImpl
 */
@Stateless
public class DaoMovimientosImpl implements DaoMovimientos {
	@PersistenceContext(unitName = "bancoUP")									
	EntityManager em;
	
	@Override
	public void altaMovimiento(Movimiento movimiento) {		
		em.persist(movimiento);
	}

	@Override
	public void eliminarMovimiento(int idMovimiento) {
		em.remove(this.obtenerMovimiento(idMovimiento));
	}

	@Override
	public List<Movimiento> movimientosCuenta(int numCuenta) {
		Cuenta cuenta = em.find(Cuenta.class,numCuenta);
		return cuenta.getMovimientos();
	}

	@Override
	public Movimiento obtenerMovimiento(int idMovimiento) {
		return em.find(Movimiento.class,idMovimiento);
	}

	@Override
	public List<Movimiento> movimientosCliente(int idCliente) {
		Cliente cliente = em.find(Cliente.class,idCliente);
		List<Cuenta> cuentas = cliente.getCuentas();
		List<Movimiento> movimientos = new ArrayList<Movimiento>();
		for(Cuenta c : cuentas) {
			for (Movimiento mov : c.getMovimientos()) {
				movimientos.add(mov);
			}
		}
		return movimientos;
	}
}
