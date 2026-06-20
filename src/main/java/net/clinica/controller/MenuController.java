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
import net.clinica.dto.MedicamentoDTO;
import net.clinica.dto.MenuDTO;
import net.clinica.entity.Medicamento;
import net.clinica.entity.Medicamento2;
import net.clinica.entity.Menu;
import net.clinica.entity.Menu2;
import net.clinica.servicesImpl.MedicamentoService2;
import net.clinica.servicesImpl.MenuService;
import net.clinica.servicesImpl.MenuService2;
import net.clinica.utils.ApiResponse;
import net.clinica.utils.BusinessException;
import net.clinica.utils.ModeloNotFoundException;
import net.clinica.utils.NotFoundException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/men")
public class MenuController {
	@Autowired
	private MenuService servicioMenu;
	@Autowired
	private ModelMapper mapper;
	
	
	@GetMapping("/lista")
	public ResponseEntity<ApiResponse<?>> lista() throws Exception{
		List<MenuDTO> lista=servicioMenu.listarTodos().stream().
				map(bean-> mapper.map(bean, MenuDTO.class)).
					collect(Collectors.toList());		
		ApiResponse<List<MenuDTO>> response=new ApiResponse<>(true,"Listado Correcto",lista);	
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@GetMapping("/buscar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> buscar(@PathVariable Integer codigo) throws Exception{
		Menu med=servicioMenu.buscarPorCodigo(codigo);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+codigo+" no encontrado");
		
		
		MenuDTO medDTO=mapper.map(med, MenuDTO.class);
			
		ApiResponse<MenuDTO> response=new ApiResponse<>(true,"Menu encontrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<ApiResponse<?>> registrar(@Valid @RequestBody MenuDTO bean) throws Exception{
		Menu med=null;
		//validar si el nombre existe
		//med=medServices.buscarNombre(bean.getNombre());
		boolean estado=servicioMenu.existsByNombre(bean.getNombre());
		if(estado==true)
			throw new BusinessException("Nombre de menu existe");
		
		
		med=mapper.map(bean, Menu.class);
		
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		med=servicioMenu.registrar(med);
		MenuDTO medDTO=mapper.map(med, MenuDTO.class);
		ApiResponse<MenuDTO> response=new ApiResponse<>(true,"Menu registrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<ApiResponse<?>> actualizar(@Valid @RequestBody MenuDTO bean) throws Exception{
		Menu med=null;
		med=servicioMenu.buscarPorCodigo(bean.getCodigo());
		//validar si existe el código
		if(med==null)
			throw new ModeloNotFoundException("Código : "+
										bean.getCodigo()+" no existe");
		
		med=mapper.map(bean, Menu.class);
		
		if(med.getFoto()=="" || med.getFoto()==null)
			med.setFoto("https://res.cloudinary.com/damcanosn/image/upload/v1761414821/notfound_x7zr8p.png");
		
		med=servicioMenu.actualizar(med);
		MenuDTO medDTO=mapper.map(med, MenuDTO.class);
		ApiResponse<MenuDTO> response=new ApiResponse<>(true,"Menu actualizado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> eliminar(@PathVariable("codigo") 
									Integer cod) throws Exception{
		Menu med=servicioMenu.buscarPorCodigo(cod);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+cod+" no existe");
		
		servicioMenu.eliminar(cod);
		ApiResponse<Void>response=new ApiResponse<>(true,
								"Menu eliminado",null);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
}










