package net.clinica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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

import jakarta.validation.Valid;
import net.clinica.dto.AlumnoDTO;
import net.clinica.dto.MedicamentoDTO;
import net.clinica.entity.Alumno;
import net.clinica.entity.Alumno2;
import net.clinica.entity.Medicamento;
import net.clinica.entity.Medicamento2;
import net.clinica.entity.Menu2;
import net.clinica.servicesImpl.AlumnoService;
import net.clinica.servicesImpl.AlumnoService2;
import net.clinica.servicesImpl.MedicamentoService2;
import net.clinica.servicesImpl.MenuService2;
import net.clinica.utils.ApiResponse;
import net.clinica.utils.BusinessException;
import net.clinica.utils.ModeloNotFoundException;
import net.clinica.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/alu")
public class AlumnoController {
	@Autowired
	private AlumnoService medServices;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/lista")
	public ResponseEntity<ApiResponse<?>> lista() throws Exception{
		List<AlumnoDTO> lista=medServices.listarTodos().stream().
				map(bean-> mapper.map(bean, AlumnoDTO.class)).
					collect(Collectors.toList());		
		ApiResponse<List<AlumnoDTO>> response=new ApiResponse<>(true,"Listado Correcto",lista);	
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@GetMapping("/buscar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> buscar(@PathVariable Integer codigo) throws Exception{
		Alumno med=medServices.buscarPorCodigo(codigo);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+codigo+" no encontrado");
		
		
		AlumnoDTO medDTO=mapper.map(med, AlumnoDTO.class);
			
		ApiResponse<AlumnoDTO> response=new ApiResponse<>(true,"Alumno encontrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<ApiResponse<?>> registrar(@Valid @RequestBody AlumnoDTO bean) throws Exception{
		Alumno med=null;
		
		
		med=mapper.map(bean, Alumno.class);
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		med=medServices.registrar(med);
		AlumnoDTO medDTO=mapper.map(med, AlumnoDTO.class);
		ApiResponse<AlumnoDTO> response=new ApiResponse<>(true,"Alumno registrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<ApiResponse<?>> actualizar(@Valid @RequestBody AlumnoDTO bean) throws Exception{
		Alumno med=null;
		med=medServices.buscarPorCodigo(bean.getCodigo());
		//validar si existe el código
		if(med==null)
			throw new ModeloNotFoundException("Código : "+
										bean.getCodigo()+" no existe");
		
		med=mapper.map(bean, Alumno.class);
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		med=medServices.actualizar(med);
		AlumnoDTO medDTO=mapper.map(med, AlumnoDTO.class);
		ApiResponse<AlumnoDTO> response=new ApiResponse<>(true,"Alumno actualizado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> eliminar(@PathVariable("codigo") 
									Integer cod) throws Exception{
		Alumno med=medServices.buscarPorCodigo(cod);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+cod+" no existe");
		
		medServices.eliminar(cod);
		ApiResponse<Void>response=new ApiResponse<>(true,
								"Alumno eliminado",null);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}










