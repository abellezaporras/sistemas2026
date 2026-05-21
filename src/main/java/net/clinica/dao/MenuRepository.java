package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.Menu;



public interface MenuRepository extends JpaRepository<Menu, Integer>{
	
	
}
