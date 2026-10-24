package net.clinica.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.AlumnoRepository;
import net.clinica.dao.AlumnoRepository2;
import net.clinica.entity.Alumno;
import net.clinica.entity.Alumno2;

@Service
public class AlumnoService extends ICRUDImpl<Alumno, Integer>{
	@Autowired
	private AlumnoRepository repo;

	@Override
	public JpaRepository<Alumno, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}


	
	
}
