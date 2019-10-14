package daos;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {
	
	boolean existe(String user, String pass);	
	
	Cliente obtenerCliente(String user, String pass);
	
	Cliente obtenerClientePorId(int idCliente);

	void registrar(Cliente c);
	
	void actualizar(Cliente c);
}
