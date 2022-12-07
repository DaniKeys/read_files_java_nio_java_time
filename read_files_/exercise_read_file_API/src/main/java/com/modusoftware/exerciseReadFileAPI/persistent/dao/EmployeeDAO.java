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
		
	
		
		
//
//		public int getMayor_age() {
//
//			DateTimeFormatter formatDateAMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			LocalDate fecha_nacimiento_format = LocalDate.parse(this.fecha_de_nacimiento, formatDateAMD);
//			LocalDate fechaActual = LocalDate.now();
//			Period menores2004 = Period.between(fecha_nacimiento_format, fechaActual);
//			int años = menores2004.getYears();
//
//			return años;
//
//		}
		
//		public String getfechaDeIngreso() {
//			
//			String antiguedadCast = this.antiguedad;
//			int fecha_ingreso_int = Integer.parseInt(antiguedadCast);
//			Period meses = Period.ofMonths(fecha_ingreso_int);
//			LocalDate fechaActual = LocalDate.now();
//			LocalDate fechaIngreso = fechaActual.minus(meses);
//			DateTimeFormatter formatDateM = DateTimeFormatter.ofPattern("MM/yyyy");
//			String fecha_ingreso_format = formatDateM.format(fechaIngreso);
//			
//			return fecha_ingreso_format;
//		}
		
//	  public LocalDate getFormatFechaNacimientoAMD() {
//			
//			DateTimeFormatter formatDateAMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			LocalDate date_format_AMD = LocalDate.parse(this.fecha_de_nacimiento, formatDateAMD);
//			
//			return date_format_AMD;
//			
//		}
//		public String getFormatFechaNacimientoDMA() {
//			
//			DateTimeFormatter formatDateAMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
//			DateTimeFormatter formatDateDMA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//			LocalDate date_format_AMD = LocalDate.parse(this.fecha_de_nacimiento, formatDateAMD);
//			String fechaDeNacimientoDMA = formatDateDMA.format(date_format_AMD);
//			
//			return fechaDeNacimientoDMA;
//			
//		}


}
