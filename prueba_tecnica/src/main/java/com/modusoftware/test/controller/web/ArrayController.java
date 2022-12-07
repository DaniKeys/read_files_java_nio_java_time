package com.modusoftware.test.controller.web;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.modusoftware.test.bussines.IArrayService;
import com.modusoftware.test.dto.ArrayDTO;
import com.modusoftware.test.persistent.entity.ArrayEntity;
import com.modusoftware.test.persistent.repository.ArrayRepository;

import net.bytebuddy.asm.Advice.Return;

/**
 * <h2>ArrayController</h2>
 * <p>
 * Este Bean que pertenece a la capa de presentacion, 
 * permite exponer los servicios de la APi REST por medio de un Body
 * para obtener las peticiones solicitadas,inyecta la {@code @Interface}
 * {@link IArrayService} 
 * 
 *             
 * @author danielcamacho
 * @version 1.0
 * @since 2022
 * 
 * {@inheritDoc}
 */

@RestController
@RequestMapping("/app")
public class ArrayController {

	
	@Autowired
	private IArrayService arrayServ;
	
	/**
	 * {@code findArrayById()} Este metodo recibe de mi URL los siguientes parametros
	 * 
	 * @param  dto recibe el Id de consulta y la iteracion en el body de la peticion
	 * @return Devuelve a la interfaz visual el valor resultante en formato {@code String}
	 * 
	 * {@inheritDoc}
	 * */

		@PostMapping(path = "/consulta")
		public String findArrayById(@RequestBody ArrayDTO dto) {
			
		ArrayDTO dtoResponse = new ArrayDTO();
		dtoResponse = this.arrayServ.result(dto); 
		
		return "Respuesta= " + dtoResponse.getRespuesta();
      


}
}
