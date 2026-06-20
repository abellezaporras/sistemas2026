package net.clinica.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicamentoRepository2;
import net.clinica.entity.Medicamento2;



@Service
public class MedicamentoService2 extends ICRUDImpl<Medicamento2, Integer>{
	@Autowired
	private MedicamentoRepository2 repo;

	@Override
	public JpaRepository<Medicamento2, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}


	
	
}
