package com.modusoftware.test.bussines.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.modusoftware.test.bussines.IArrayService;
import com.modusoftware.test.dto.ArrayDTO;
import com.modusoftware.test.persistent.entity.ArrayEntity;
import com.modusoftware.test.persistent.repository.ArrayRepository;
import com.modusoftware.test.util.operationInvalid.ValidRequest;

/**
 * <h2>ArrayServiceImpl</h2>
 * <p>
 * Este Bean que pertenece a la capa de logica, desarrolla la logica para dar el conjunto de valores resultantes 
 * inyectando el Bean  {@link ArrayRepository} para obtener informacin de la Base de Datos
 * implementa {@code @FuncionalInterface} {@link IArrayService} donde esta definido el "SAB"
 * {@code getArrayById()}
 * </p>
 * 
 * @author danielcamacho
 * @version 1.0
 * @since 2022
 * 
 */

@Service
public class ArrayServiceImpl implements IArrayService {

	@Autowired
	private ArrayRepository arrayRep;
	
	
	/**
	 * {@inheritDoc}
	 * 
	 * */

	@Override
	public String getArrayById(Integer id, Integer q) {
		
		long count = this.arrayRep.count();
		
		if(id > count || id <= 0) {
			return "." + ValidRequest.NOT_FOUND_ID;
		}else if(q > 6){
			return ValidRequest.INDEX_OUT_OF_BOUNDS + " \nLa cantidad de iteraciones: "+q+" es innecesaria," +
					"\ndespues de la 6 iteracion los resutlados son los mismos "
					+ "\nya que el numero mas alto  de la base de datos (13) es operable en la (6) iteracion";
		}
		
		
		Optional<ArrayEntity> arraysEntity = this.arrayRep.findById(id);
		List<String> obtArray = arraysEntity.stream()
				                            .map(x -> x.getInputArray())
				                            .collect(Collectors.toList());

		String[] numArray = new String[obtArray.size()];

		for (int c = 0; c < obtArray.size(); c++) {
			numArray = obtArray.get(c).split(",");
		}

		List<Integer> p = Arrays.asList(2, 3, 5, 7, 11, 13);
		Stack<Integer> a = new Stack<>();

		for (int h = 0; h < numArray.length; h++) {
			a.add(Integer.valueOf(numArray[h]));
		}

		List<Integer> b = new ArrayList<>();
		List<Integer> ai = new ArrayList<>();
		List<Integer> respuesta = new ArrayList<>();

		int i;
		int pIter = 0;

		while (q > 0) {

			 while(!a.isEmpty()) {

				if (a.lastElement() % p.get(pIter) == 0) {
					b.add(a.pop());

				} else if (a.lastElement() % p.get(pIter) != 0) {
					ai.add(a.pop());
				}
			}
			q--;
			
			if (q > 0) {
				pIter++;

				for (int j = 0; j < ai.size(); j++) {
					a.add(ai.get(j));
				}
				ai.clear();
			} else{
				respuesta.addAll(b);
				ai.stream().sorted();
				respuesta.addAll(ai);
			}
		}

		String result = respuesta.stream()
				                 .map(x -> String.valueOf(x))
				                 .collect(Collectors.joining(","));
		return result;

	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * */
		@Override
		public ArrayDTO result(ArrayDTO dto) {
		
		ArrayDTO dtoResult = new ArrayDTO(); 
		
		dtoResult.setRespuesta(this.getArrayById(dto.getId(), dto.getQ()));
		
		
		return dtoResult;
		
	}
	
		
}
	
	
		

//				                             