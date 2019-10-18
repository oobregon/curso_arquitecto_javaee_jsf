package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import daos.DaoVentas;
import model.Venta;
import utilidades.ContextoApp;

@ManagedBean(name = "ventasBean")
@RequestScoped
public class VentasBean {
	private List<Venta> ventas;
	
	@EJB
	DaoVentas ejbVentas;
	
	@ManagedProperty("#{loginBean}")
	LoginBean loginBean;
	
	@PostConstruct
	private void cargaVentas() {
		int idCliente = loginBean.getCliLogado().getIdCliente();
		ventas = ejbVentas.obtenerVentasCliente(idCliente);			
	}
	
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public String cerrarSesion() {		
		// FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		ContextoApp.obtenerSesion().invalidate();
		return "login";
	}
}
