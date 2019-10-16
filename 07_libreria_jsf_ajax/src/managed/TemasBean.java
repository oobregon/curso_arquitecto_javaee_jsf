package managed;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import daos.DaoTemas;
import model.Tema;

@ManagedBean(name = "temasBean")
@RequestScoped
public class TemasBean {
	private int idTema;
	private List<Tema> temas;

	@EJB
	DaoTemas temasEjb;	
	
	@PostConstruct
	private void cargaTemas() {
		temas = temasEjb.obtenerTemas();
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	// No merece la pena tener un método de accion, cuya única misión es 
	public String mostrarLibros() {
		return "libros";
	}	
}
