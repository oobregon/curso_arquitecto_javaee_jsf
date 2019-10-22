package model;

import java.util.Date;

public class Intervalo {
	private Date fechaIni;
	private Date fechaFin;
	
	public Intervalo(Date fini,Date ffin) {
		fechaIni = fini;
		fechaFin = ffin;
	}
	
	public Date getFechaIni() {
		return fechaIni;
	}
	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}
	public Date getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}	
}
