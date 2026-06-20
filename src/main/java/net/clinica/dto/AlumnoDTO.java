package net.clinica.dto;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public class AlumnoDTO {

	private Integer codigo;
    @NotBlank(message = "{alu.nombre.vacio}")
    private String nombre;

    @NotBlank(message = "{alu.paterno.vacio}")
    private String paterno;

    @NotBlank(message = "{alu.materno.vacio}")
    private String materno;

    @NotBlank(message = "{alu.sexo.vacio}")
    private String sexo;

    @NotNull(message = "{alu.fechaNacimiento.vacio}")
    private LocalDate fechaNacimiento;

    @Min(value = 0, message = "{alu.hermanos.min}")
    @Max(value = 20, message = "{alu.hermanos.max}")
    private int numeroHermanos;


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
	public String getPaterno() {
		return paterno;
	}
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}
	public String getMaterno() {
		return materno;
	}
	public void setMaterno(String materno) {
		this.materno = materno;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getNumeroHermanos() {
		return numeroHermanos;
	}
	public void setNumeroHermanos(int numeroHermanos) {
		this.numeroHermanos = numeroHermanos;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
	
}



