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

import net.clinica.entity.Alumno;
import net.clinica.entity.Medicamento;
import net.clinica.entity.Menu;
import net.clinica.servicesImpl.AlumnoService;
import net.clinica.servicesImpl.MedicamentoService;
import net.clinica.servicesImpl.MenuService;
import net.clinica.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
	@Autowired
	private AlumnoService servicioAlu;
	
	//select *from tb_medicamento --->JSON
	@GetMapping("/lista")
	public ResponseEntity<List<Alumno>> lista() throws Exception{
		
		return new ResponseEntity<>(servicioAlu.listarTodos(),HttpStatus.OK);
	}
	
	//select *from tb_medicamento where cod_med=1--->JSON
	@GetMapping("/buscar/{codigo}") //   /buscar/4
	public ResponseEntity<Alumno> buscar(@PathVariable("codigo") Integer cod) throws Exception{
		Alumno med=servicioAlu.buscarPorCodigo(cod);
		//validar
		if(med==null)
			throw new NotFoundException();
		
		return new ResponseEntity<>(med,HttpStatus.OK);
	}
	
	//registrar --- insert into
	@PostMapping("/registrar")//recibe un JSON
	public ResponseEntity<Alumno> registrar(@RequestBody Alumno med) throws Exception{
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		if(med.getNombre()==null)
			med.setNombre("");
		
		if(med.getPaterno()==null)
			med.setPaterno("");
		
		if(med.getMaterno()==null)
			med.setMaterno("");
		
		if(med.getSexo()==null)
			med.setSexo("");
		
		
		Alumno bean=servicioAlu.registrar(med);
		
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}
	
	//actualizar --- update
	@PutMapping("/actualizar")//recibe un JSON
	public ResponseEntity<Alumno> actualizar(@RequestBody Alumno med) throws Exception{
		Alumno bean=servicioAlu.buscarPorCodigo(med.getCodigo());
		//validar
		if(bean==null)
			throw new NotFoundException();
		else {
			if(med.getFoto()=="" || med.getFoto()==null)
				med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
			
			if(med.getNombre()==null)
				med.setNombre("");
			
			if(med.getPaterno()==null)
				med.setPaterno("");
			
			if(med.getMaterno()==null)
				med.setMaterno("");
			
			if(med.getSexo()==null)
				med.setSexo("");
			
			bean=servicioAlu.actualizar(med);
		
		}
		return new ResponseEntity<>(bean,HttpStatus.OK);
	}
	
	//eliminar ---delete
	@DeleteMapping("/eliminar/{codigo}")	//	/eliminar/2
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		Alumno bean=servicioAlu.buscarPorCodigo(cod);
		//validar
		if(bean==null)
			throw new NotFoundException();
		else
			servicioAlu.eliminar(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}










