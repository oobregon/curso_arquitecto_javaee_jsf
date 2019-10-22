package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="todos", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(unique=true, nullable=false)
	private int dni;

	@Column(nullable=false, length=45)
	private String direccion;

	@Column(nullable=false, length=45)
	private String nombre;

	@Column(nullable=false)
	private int telefono;

	//bi-directional many-to-many association to Cuenta
	// Las siguientes anotaciones (configuracion) están referidas al miembro privado "cuentas", es decir,
	// la relación de Cliente con Cuenta.
	// @ManyToMany. Cuando se elimine un Cliente, se eliminan también sus cuentas, porque esta configuración
	// es contra el miembro "cuentas".
	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "Titulares",
	joinColumns = @JoinColumn(name = "idCliente",referencedColumnName = "dni"),
	inverseJoinColumns = @JoinColumn(name = "idCuenta",referencedColumnName = "numeroCuenta"))
	private List<Cuenta> cuentas;

	public Cliente(int dni, String direccion, String nombre, int telefono) {
		super();
		this.dni = dni;
		this.direccion = direccion;
		this.nombre = nombre;
		this.telefono = telefono;
	}

	public Cliente() {
	}

	public int getDni() {
		return this.dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Cuenta> getCuentas() {
		return this.cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

}