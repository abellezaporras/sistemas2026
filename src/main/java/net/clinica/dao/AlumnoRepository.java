package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.Alumno;



public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	
}
