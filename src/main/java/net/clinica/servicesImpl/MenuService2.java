package net.clinica.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicamentoRepository2;
import net.clinica.dao.MenuRepository2;
import net.clinica.entity.Medicamento2;
import net.clinica.entity.Menu2;



@Service
public class MenuService2 extends ICRUDImpl<Menu2, Integer>{
	@Autowired
	private MenuRepository2 repo;

	@Override
	public JpaRepository<Menu2, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}


	
	
}
