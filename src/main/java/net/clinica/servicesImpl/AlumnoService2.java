package net.clinica.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.AlumnoRepository2;
import net.clinica.entity.Alumno2;

@Service
public class AlumnoService2 extends ICRUDImpl<Alumno2, Integer>{
	@Autowired
	private AlumnoRepository2 repo;

	@Override
	public JpaRepository<Alumno2, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}


	
	
}
