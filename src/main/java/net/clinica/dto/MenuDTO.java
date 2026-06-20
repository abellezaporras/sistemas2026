package net.clinica.dto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class MenuDTO {
	private Integer codigo;
	@NotNull(message = "{menu.nombre.nulo}")
    @NotBlank(message = "{menu.nombre.vacio}")
	private String nombre;
	@NotNull(message = "{menu.categoria.nulo}")
	@NotBlank(message = "{menu.categoria.vacio}")
	private String categoria;
	@Min(value = 1, message = "{menu.stock.min}")
	@Max(value = 40, message = "{menu.stock.max}")
	private int stock;
	@DecimalMin(value = "15.0", message = "{menu.precio.min}")
	@DecimalMax(value = "150.00", message = "{menu.precio.max}")
	private double precio;
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



