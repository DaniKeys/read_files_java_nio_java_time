package com.modusoftware.test.bussines;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.modusoftware.test.dto.ArrayDTO;
import com.modusoftware.test.persistent.entity.ArrayEntity;

@Service
public interface IArrayService {
	
	/**
	 * {@code getArrayById()} Este metodo consulta el array por ID 
	 * y no es posible de implementar en la interface
	 * 
	 * @param id recibe el Id de consulta
	 * @param q recibe la cantidad de veces que se va a iterar el arreglo consultado
	 * @return Devuelve el array final cast a {@code String}
	 * 
	 * {@inheritDoc}
	 * */

	public String getArrayById(Integer id,  Integer q);
	
	/**
	 * {@code result()} Este metodo interactua con el otro metodo de la clase  {@code getArrayById()}
	 * para enviarle los valores recibidos por DTOs
	 * 
	 * @param dto obtiene de un objeto DTOs el Id de consulta y la cantidad de Iteraciones
	 * @return Devuelve en un objeto DTOs con la propiedad de respuesta inicializada con el valor obtenido 
	 * del retorno del metodo {@code getArrayById()}
	 * 
	 * {@inheritDoc}
	 * */
	public ArrayDTO result(ArrayDTO dto);
 
}
