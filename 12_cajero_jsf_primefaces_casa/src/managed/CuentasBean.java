package managed;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Intervalo;
import model.Movimiento;

@ManagedBean (name = "cuentasBean")
@RequestScoped
public class CuentasBean {
	private List<Cuenta> cuentas;	
	private List<Movimiento> movimientos = new ArrayList<Movimiento>();
	private int idCuenta;
	private Intervalo intervalo;	
	
	@EJB
	DaoCuentas ejbCuentas;
	
	@EJB
	DaoMovimientos ejbMovs;
	
	@PostConstruct
	private void inicio() {
		setCuentas(ejbCuentas.obtenerCuentas());		
		Intervalo intervalo = new Intervalo(new Date(),new Date());
		setIntervalo(intervalo);
	}
	
	public void cargarMovimientos() {
		int idCuenta = getIdCuenta();
		setMovimientos(idCuenta==0?null:ejbMovs.obtenerMovimientosFecha(idCuenta,getIntervalo()));
	}		
	
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public List<Movimiento> getMovimientos() {
		this.cargarMovimientos();
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

	public Intervalo getIntervalo() {
		return intervalo;
	}

	public void setIntervalo(Intervalo intervalo) {
		this.intervalo = intervalo;
	}	
}
