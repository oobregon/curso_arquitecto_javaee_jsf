package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * The persistent class for the libros database table.
 * 
 */
@Entity
@Table(name="libros")
@NamedQuery(name="todos", query="SELECT l FROM Libro l")
public class Libro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int isbn;

	private String autor;

	private int paginas;

	private double precio;

	private String titulo;

	//bi-directional many-to-one association to Tema
	@ManyToOne
	@JoinColumn(name="idTema",referencedColumnName = "idTema")
	private Tema tema;
	
	//bi-directional many-to-one association to Venta
	@OneToMany(mappedBy="libro")
	private List<Venta> ventas;

	public Libro() {
	}

	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return this.paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Tema getTema() {
		return this.tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	public List<Venta> getVentas() {
		return this.ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}
}