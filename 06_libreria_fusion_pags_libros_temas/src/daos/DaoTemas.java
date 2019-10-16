package daos;

import java.util.List;

import javax.ejb.Local;

import model.Tema;

@Local
public interface DaoTemas {
	List<Tema> obtenerTemas();
}
