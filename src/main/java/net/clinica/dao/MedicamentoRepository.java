package net.clinica.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import net.clinica.entity.Medicamento;
import net.clinica.entity.Medicamento2;



public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	
	boolean existsByNombre(String nom);
}
