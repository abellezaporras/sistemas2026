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
import net.clinica.entity.Menu2;
import net.clinica.servicesImpl.MedicamentoService2;
import net.clinica.servicesImpl.MenuService;
import net.clinica.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/menu")
public class MenuController {
	@Autowired
	private MenuService servicioMenu;
	
	//select *from tb_medicamento --->JSON
	@GetMapping("/lista")
	public ResponseEntity<List<Menu2>> lista() throws Exception{
		
		return new ResponseEntity<>(servicioMenu.listarTodos(),HttpStatus.OK);
	}
	
	//select *from tb_medicamento where cod_med=1--->JSON
	@GetMapping("/buscar/{codigo}") //   /buscar/4
	public ResponseEntity<Menu2> buscar(@PathVariable("codigo") Integer cod) throws Exception{
		Menu2 med=servicioMenu.buscarPorCodigo(cod);
		//validar
		if(med==null)
			throw new NotFoundException();
		
		return new ResponseEntity<>(med,HttpStatus.OK);
	}
	
	//registrar --- insert into
	@PostMapping("/registrar")//recibe un JSON
	public ResponseEntity<Menu2> registrar(@RequestBody Menu2 med) throws Exception{
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		if(med.getNombre()==null)
			med.setNombre("");
		
		if(med.getCategoria()==null)
			med.setCategoria("");
		
		
	
		Menu2 bean=servicioMenu.registrar(med);
		
		return new ResponseEntity<>(bean,HttpStatus.CREATED);
	}
	
	//actualizar --- update
	@PutMapping("/actualizar")//recibe un JSON
	public ResponseEntity<Menu2> actualizar(@RequestBody Menu2 med) throws Exception{
		Menu2 bean=servicioMenu.buscarPorCodigo(med.getCodigo());
		//validar
		if(bean==null)
			throw new NotFoundException();
		else {
			
			if(med.getFoto()=="" || med.getFoto()==null)
				med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
			
			if(med.getNombre()==null)
				med.setNombre("");
			
			if(med.getCategoria()==null)
				med.setCategoria("");
			
			bean=servicioMenu.actualizar(med);
			
			
		}
		
		return new ResponseEntity<>(bean,HttpStatus.OK);
	}
	
	//eliminar ---delete
	@DeleteMapping("/eliminar/{codigo}")	//	/eliminar/2
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		Menu2 bean=servicioMenu.buscarPorCodigo(cod);
		//validar
		if(bean==null)
			throw new NotFoundException();
		else
			servicioMenu.eliminar(cod);
		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}










