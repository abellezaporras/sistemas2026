package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.Alumno;
import net.clinica.entity.Alumno2;



public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{
	
	
}
