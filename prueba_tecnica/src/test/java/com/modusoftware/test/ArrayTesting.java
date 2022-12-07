package com.modusoftware.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.modusoftware.test.bussines.IArrayService;
import com.modusoftware.test.bussines.impl.ArrayServiceImpl;
import com.modusoftware.test.controller.web.ArrayController;
import com.modusoftware.test.persistent.entity.ArrayEntity;
import com.modusoftware.test.persistent.repository.ArrayRepository;
import com.modusoftware.test.util.operationInvalid.ValidRequest;

import junit.framework.Assert;

/**
* <h2>ArrayTesting</h2>
* <p>
* Este Bean de Testing, desarrolla las pruebas unitarias, validando escenarios tanto validos como invalidos 
* implementa librerias de Junit, inyecta el Bean {@link ArrayServiceImpl} para invocar la implemetacion de la logica
* 
* 
* @author danielcamacho
* @version 1.0
* @since 2022
* 
*/

@SpringBootTest
class ArrayTesting {
	
	
	@Autowired
	ArrayServiceImpl aServ;

	
	//////////////////////////////////////  ID-5    ///////////////////////////////////////
	
	/**
	 * {@code array_id_5_first_iteration()} 
	 * Este metodo valida el escenario de una iteracion de los valores del ID 5
	 * divididdo por el numero (2) el primer elemento de la lista de primos 
	 *
	 * */
	
	@Test
	void array_id_5_first_iteration() {//DIV2

//	    Q1:
//		B=10
//		A1=9,11,15,7
//		Respuesta=10
		
    assertEquals("10,9,11,15,7", this.aServ.getArrayById(5, 1));
    
	}
	/**
	 *{@code array_id_5_second_iteration() } 
	 * Este metodo valida el escenario de dos iteraciones de los valores del ID 5
	 * divididdo por el numero (3) el segundo elemento de la lista de primos 
	 * */
	
	@Test
	void array_id_5_second_iteration() {//DIV3

//	    Q2:
//		B=15,9
//		A1=9,11,15,7
//		A2=7,11
//		Respuesta=10,15,9

    assertEquals("10,15,9,7,11", this.aServ.getArrayById(5, 2));
    
	}
	/**
	 * {@code array_id_5_tercer_iteration() } 
	 * Este metodo valida el escenario de tres iteraciones de los valores del ID 5
	 * divididdo por el numero (5) el tercer elemento de la lista de primos 
	 *
	 * */
	
	@Test
	void array_id_5_tercer_iteration() {//DIV5

//	    Q3:
//		B=
//		A2=7,11
//		A3=11,7
//		Respuesta=10,15,9

    assertEquals("10,15,9,11,7", this.aServ.getArrayById(5, 3));
    
	}
	/**
	 * {@code array_id_5_cuarta_iteration()} 
	 * Este metodo valida el escenario de cuatro iteraciones de los valores del ID 5
	 * dividido por el numero (5) el cuarto elemento de la lista de primos 
	 * */
	@Test
	void array_id_5_cuarta_iteration() {//DIV7

//	    Q4:
//		B=7
//		A3=11,7
//		A4=11
//		Respuesta=10,15,9,7
		
    assertEquals("10,15,9,7,11", this.aServ.getArrayById(5, 4));
    
	}
	
	
/////////////////////////////////// INVALID-OPERATION//////////////////////////
	
	/**
	 * {@code id_not_found()} 
	 * Este metodo valida el escenario de un ID no perteneciente a la BD
	 * */
	
	
	@Test
	void id_not_found() {

		
    assertEquals(".NOT_FOUND_ID", this.aServ.getArrayById(0, 1));
    
	}
}
