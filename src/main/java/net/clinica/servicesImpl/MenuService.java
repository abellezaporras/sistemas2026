package net.clinica.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import net.clinica.dao.MedicamentoRepository2;
import net.clinica.dao.MenuRepository;
import net.clinica.dao.MenuRepository2;
import net.clinica.entity.Medicamento2;
import net.clinica.entity.Menu;
import net.clinica.entity.Menu2;



@Service
public class MenuService extends ICRUDImpl<Menu, Integer>{
	@Autowired
	private MenuRepository repo;

	@Override
	public JpaRepository<Menu, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return repo;
	}

	public boolean existsByNombre(String nom) {
		return repo.existsByNombre(nom);
	}
	
	
}
