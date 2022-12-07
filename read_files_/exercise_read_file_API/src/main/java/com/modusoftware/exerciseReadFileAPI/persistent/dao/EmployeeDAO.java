package com.modusoftware.exerciseReadFileAPI.persistent.dao;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeDAO {
	

		String nombre;
		String apellido;
		String genero;
	    String fecha_de_nacimiento;
		String cargo;
		String antiguedad;
		
	
		



}
