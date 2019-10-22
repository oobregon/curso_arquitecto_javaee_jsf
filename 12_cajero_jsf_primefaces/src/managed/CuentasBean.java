package managed;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoCuentas;
import daos.DaoMovimientos;
import model.Cuenta;
import model.Movimiento;

@ManagedBean (name = "cuentasBean")
@RequestScoped
public class CuentasBean {
	private List<Cuenta> cuentas;	
	private List<Movimiento> movimientos;
	private int idCuenta = 0;
	private Date fechaIni;
	private Date fechaFin;
	
	@EJB
	DaoCuentas ejbCuentas;
	
	@EJB
	DaoMovimientos ejbMovs;
	
	@PostConstruct
	private void inicio() {
		setCuentas(ejbCuentas.obtenerCuentas());		
	}
	
	private void cargarMovimientos() {
		List<Movimiento> movs;
		int numCuenta = getIdCuenta();
		IntervaloFechas intervalo = new IntervaloFechas(getFechaIni(),getFechaFin());
		if(intervalo.getFechaInferior()==null || intervalo.getFechaSuperior()==null) {
			movs = numCuenta==0?null:ejbMovs.movimientosCuenta(numCuenta);
		} else {
			movs = numCuenta==0?null:ejbMovs.movimientosCuenta(numCuenta,intervalo);
		}
			 
		setMovimientos(movs);		
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

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}		
}
