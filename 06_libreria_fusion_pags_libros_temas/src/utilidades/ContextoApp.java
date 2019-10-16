package utilidades;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class ContextoApp {
	static ExternalContext econtext;
	static {
		econtext = FacesContext.getCurrentInstance().getExternalContext();
	}
	
	public static HttpSession obtenerSesion() {
		// Si no hay sesión, pues que la construya.
		// FacesContext.getCurrentInstance().getExternalContext().getSession(true)		
		return ((HttpServletRequest)econtext.getRequest()).getSession();
	}
	
	public static HttpServletRequest obtenerRequest() {
		return ((HttpServletRequest)econtext.getRequest());
	}
}
