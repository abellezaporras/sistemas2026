package net.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.clinica.entity.Medicamento2;
import net.clinica.servicesImpl.MedicamentoService2;
import net.clinica.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController2 {
	@Autowired
	private MedicamentoService2 servicioMed;
	
	//select *from tb_medicamento --->JSON
	@GetMapping("/lista")
	public ResponseEntity<List<Medicamento2>> lista() throws Exception{
		
		return new ResponseEntity<>(servicioMed.listarTodos(),HttpStatus.OK);
	}
	
	//select *from tb_medicamento where cod_med=1--->JSON
	@GetMapping("/buscar/{codigo}") //   /buscar/4
	public ResponseEntity<Medicamento2> buscar(@PathVariable("codigo") Integer cod) throws Exception{
		Medicamento2 med=servicioMed.buscarPorCodigo(cod);
		//validar
		if(med==null)
			throw new NotFoundException();
		
		return new ResponseEntity<>(med,HttpStatus.OK);
	}
	
	//registrar --- insert into
	@PostMapping("/registrar")//recibe un JSON
	public ResponseEntity<Medicamento2> registrar(@RequestBody Medicamento2 med) throws Exception{
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		if(med.getNombre()==null)
			med.setNombre("");
			
		Medicamento2 bean=servicioMed.registrar(med);
		
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}
	
	//actualizar --- update
	@PutMapping("/actualizar")//recibe un JSON
	public ResponseEntity<Medicamento2> actualizar(@RequestBody Medicamento2 med) throws Exception{
		Medicamento2 bean=servicioMed.buscarPorCodigo(med.getCodigo());
		//validar
		if(bean==null)
			throw new NotFoundException();
		else {
			if(med.getFoto()=="" || med.getFoto()==null)
				med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
			
			if(med.getNombre()==null)
				med.setNombre("");
			
			bean=servicioMed.actualizar(med);
			
		}
		
		return new ResponseEntity<>(bean,HttpStatus.OK);
	}
	
	//eliminar ---delete
	@DeleteMapping("/eliminar/{codigo}")	//	/eliminar/2
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		Medicamento2 bean=servicioMed.buscarPorCodigo(cod);
		//validar
		if(bean==null)
			throw new NotFoundException();
		else
			servicioMed.eliminar(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}










