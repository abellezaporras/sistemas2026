package net.clinica.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class MedicamentoDTO {
	private Integer codigo;
	@NotNull(message = "{med.nombre.nulo}")
	@NotBlank(message = "{med.nombre.vacio}")
	private String nombre;
	@Min(value = 1,message = "{med.stock.min}")
	@Max(value = 100,message = "{med.stock.max}")
	private int stock;
	private double precio;
	private String foto;
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
}














