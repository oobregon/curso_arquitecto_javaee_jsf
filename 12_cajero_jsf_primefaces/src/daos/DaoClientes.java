package daos;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import model.Cliente;

@Local
public interface DaoClientes {
	void altaCliente(Cliente cliente);
	List<Cliente> clientesDeCuenta(int numeroCuenta);
	void eliminarCliente(int idCliente);
	List<Cliente> clienteConMovimientos(Date fecha);
	Cliente obtenerCliente(int idCliente);
	List<Cliente> obtenerClientes();
}
