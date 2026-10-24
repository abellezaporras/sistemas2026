package net.clinica.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cod_alu")
	private Integer codigo;
	@Column(name="nom_alu")
	private String nombre;
	@Column(name="pat_alu")
	private String paterno;
	@Column(name="mat_alu")
	private String materno;
	@Column(name="sexo_alu")
	private String sexo;
	@Column(name="fec_nac_alu")
	private LocalDate fechaNacimiento;
	@Column(name="num_her")
	private int numeroHermanos;
	@Column(name="foto_med", length = 400)
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



