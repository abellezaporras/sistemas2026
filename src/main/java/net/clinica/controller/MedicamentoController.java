package net.clinica.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import net.clinica.entity.Medicamento;
import net.clinica.servicesImpl.MedicamentoService;
import net.clinica.servicesImpl.MedicamentoService2;
import net.clinica.utils.ApiResponse;
import net.clinica.utils.BusinessException;
import net.clinica.utils.ModeloNotFoundException;

@RestController
@RequestMapping("/med")
public class MedicamentoController {
	@Autowired
	private MedicamentoService medServices;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping("/lista")
	public ResponseEntity<ApiResponse<?>> lista() throws Exception{
		List<MedicamentoDTO> lista=medServices.listarTodos().stream().
				map(bean-> mapper.map(bean, MedicamentoDTO.class)).
					collect(Collectors.toList());		
		ApiResponse<List<MedicamentoDTO>> response=new ApiResponse<>(true,"Listado Correcto",lista);	
		
		return new ResponseEntity<>(response,HttpStatus.OK);		
	}
	
	@GetMapping("/buscar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> buscar(@PathVariable Integer codigo) throws Exception{
		Medicamento med=medServices.buscarPorCodigo(codigo);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+codigo+" no encontrado");
		
		
		MedicamentoDTO medDTO=mapper.map(med, MedicamentoDTO.class);
			
		ApiResponse<MedicamentoDTO> response=new ApiResponse<>(true,"Medicamento encontrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<ApiResponse<?>> registrar(@Valid @RequestBody MedicamentoDTO bean) throws Exception{
		Medicamento med=null;
		//validar si el nombre existe
		//med=medServices.buscarNombre(bean.getNombre());
		boolean estado=medServices.existsByNombre(bean.getNombre());
		if(estado==true)
			throw new BusinessException("Nombre de medicamento existe");
		
		
		med=mapper.map(bean, Medicamento.class);
		med=medServices.registrar(med);
		MedicamentoDTO medDTO=mapper.map(med, MedicamentoDTO.class);
		ApiResponse<MedicamentoDTO> response=new ApiResponse<>(true,"Medicamento registrado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}

	@PutMapping("/actualizar")
	public ResponseEntity<ApiResponse<?>> actualizar(@Valid @RequestBody MedicamentoDTO bean) throws Exception{
		Medicamento med=null;
		med=medServices.buscarPorCodigo(bean.getCodigo());
		//validar si existe el código
		if(med==null)
			throw new ModeloNotFoundException("Código : "+
										bean.getCodigo()+" no existe");
		
		med=mapper.map(bean, Medicamento.class);		
		med=medServices.actualizar(med);
		MedicamentoDTO medDTO=mapper.map(med, MedicamentoDTO.class);
		ApiResponse<MedicamentoDTO> response=new ApiResponse<>(true,"Medicamento actualizado",medDTO);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/eliminar/{codigo}")
	public  ResponseEntity<ApiResponse<?>> eliminar(@PathVariable("codigo") 
									Integer cod) throws Exception{
		Medicamento med=medServices.buscarPorCodigo(cod);
		if(med==null)
			throw new ModeloNotFoundException("Código : "+cod+" no existe");
		
		medServices.eliminar(cod);
		ApiResponse<Void>response=new ApiResponse<>(true,
								"Medicamento eliminado",null);
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}







