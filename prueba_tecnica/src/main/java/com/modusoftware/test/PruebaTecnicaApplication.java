package com.modusoftware.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Optional;
import java.util.Stack;
import java.util.stream.Collectors;
import org.hibernate.internal.build.AllowSysOut;
import org.hibernate.mapping.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.modusoftware.test.bussines.IArrayService;
import com.modusoftware.test.dto.ArrayDTO;
import com.modusoftware.test.persistent.entity.ArrayEntity;
import com.modusoftware.test.persistent.repository.ArrayRepository;

/**
 * <h1>Proyecto prueba Técnica Modusoftware </h1>
 * 
 * Descripcion
 * <p>
 * {@code PruebaTecnicaApplication } es una APi REST de consultas 
 * y retorna una operacion matematica. insercion de datos de consulta por Body.
 * La logica del proyecto es recorrer una lista de numeros y hacer operaciones
 * matematicas con un arreglo de numeros primos, operaciones entre ellas
 * modulos, dependiendo del residuo se almacenan en listas independientes.
 * </p>
 * 
 * Tecnologias y componentes:<br>
 * 
 * STS,MySql,Postman,SpringBoot,SpringDataJPA,Junit,lombok <br>
 * 
 * Instrucciones de uso
 *  <p>
 * Cree la base de datos, el archivo `script.sql` dado en el empaquetamiento del proyecto
 * Inserte la siguiente URL en su cliente o navegador despues 
 * cree un body en formato JSON donde estipule el id y numero de iteracion
 * tenga presente la informacion del endpoint y su nombre de recurso
 * 
 *
 * 
 * 
 * 
 * @author danielcamacho
 * @version 1.0
 * @since 2022
 * 
 * 
 */

@SpringBootApplication
public class PruebaTecnicaApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaApplication.class, args);
		
	}
	
	@Autowired
	private IArrayService arrayServ; 
   
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			
			ArrayDTO dto = new ArrayDTO();
			ArrayDTO dtoRta = new ArrayDTO();
			dto.setId(1);
			dto.setQ(3);
		
			dtoRta = this.arrayServ.result(dto);
			System.out.println("Respuesta= " + dtoRta.getRespuesta());
			
		};
	} 
}

