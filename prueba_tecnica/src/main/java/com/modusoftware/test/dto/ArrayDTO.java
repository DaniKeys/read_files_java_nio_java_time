package com.modusoftware.test.dto;

import lombok.Data;

/**
* <h2>ArrayDTO</h2>
* <p>
* Esta Clase que pertenece al dominio transporta la informacion en objetos, 
* evitando el contacto directo de consumir el servicio directamente con la persistencia y viseversa
* posee atributos nuevos {@code q} para la generacion de la logica y retorno de la operacion {@code respuesta}
* usa lombok para la generacion de los metodos GET y SET,
*              
* @author danielcamacho
* @version 1.0
* @since 2022
* 
* {@inheritDoc}
* 
*/
@Data
public class ArrayDTO {
	
	private Integer id;
	private Integer q;
	private String respuesta;

}
