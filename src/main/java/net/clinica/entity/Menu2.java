package net.clinica.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_menu")
public class Menu2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_menu")
	private Integer codigo;
	@Column(name="nom_menu")
	private String nombre;
	@Column(name="cate_menu")
	private String categoria;
	@Column(name="sto_menu")
	private int stock;
	@Column(name="pre_menu")
	private double precio;
	@Column(name="foto_menu", length = 400)
	private String foto;
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}



