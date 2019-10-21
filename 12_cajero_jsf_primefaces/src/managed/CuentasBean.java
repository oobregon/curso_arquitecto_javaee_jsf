package managed;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientosImpl;
import model.Cuenta;
import model.Movimiento;

@ManagedBean (name = "cuentasBean")
@RequestScoped
public class CuentasBean {
	private List<Cuenta> cuentas;	
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();
	private int idCuenta = 0;
	
	@EJB
	DaoCuentas ejbCuentas;
	
	@EJB
	DaoMovimientosImpl ejbMovs;
	
	@PostConstruct
	private void inicio() {
		setCuentas(ejbCuentas.obtenerCuentas());
		setMovimientos(ejbMovs.movimientosCuenta(getIdCuenta()));
	}
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public List<Movimiento> getMovimientos() {
		return movimientos;
	}
	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public int getIdCuenta() {
		return idCuenta;
	}

	public void setIdCuenta(int idCuenta) {
		this.idCuenta = idCuenta;
	}		
}
