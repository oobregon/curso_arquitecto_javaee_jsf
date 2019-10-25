package dao.interfaces;

import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {
	List<Cliente> findClienteByCuenta(int idCuenta);
	void saveCliente(Cliente cliente);
	void updateCliente(Cliente cliente);
	void removeCliente(int dni);
}
