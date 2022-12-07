package com.modusoftware.test.persistent.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import lombok.Data;

/**
* <h2>ArrayRepository</h2>
* <p>
* Este Bean que pertenece a la capa de persistencia, 
* realiza mapeo de mis objetos relacionales de la Base de Datos, uso de lombok 
* para la generacion de los metodos GET y SET
*              
* @author danielcamacho
* @version 1.0
* @since 2022
* 
*/

@Data
@Table(name = "arrays")
@Entity
public class ArrayEntity {

	
	@Id
	private Integer id;
	
	@Column(name = "input_array")
	private String inputArray;
	
	
}
