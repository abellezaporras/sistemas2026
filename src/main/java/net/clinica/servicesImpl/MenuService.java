package net.clinica.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicamentoRepository;
import net.clinica.dao.MenuRepository;
import net.clinica.entity.Medicamento;
import net.clinica.entity.Menu;



@Service
public class MenuService extends ICRUDImpl<Menu, Integer>{
	@Autowired
	private MenuRepository repo;

	@Override
	public JpaRepository<Menu, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}


	
	
}
