package managed;

import java.util.Date;

public class IntervaloFechas {
	private Date fechaInferior;
	private Date fechaSuperior;
	
	public IntervaloFechas(Date limInferior,Date limSuperior) {
		fechaInferior = limInferior;
		fechaSuperior = limSuperior;
	}

	public Date getFechaSuperior() {
		return fechaSuperior;
	}

	public void setFechaSuperior(Date fechaSuperior) {
		this.fechaSuperior = fechaSuperior;
	}

	public Date getFechaInferior() {
		return fechaInferior;
	}

	public void setFechaInferior(Date fechaInferior) {
		this.fechaInferior = fechaInferior;
	}

}
