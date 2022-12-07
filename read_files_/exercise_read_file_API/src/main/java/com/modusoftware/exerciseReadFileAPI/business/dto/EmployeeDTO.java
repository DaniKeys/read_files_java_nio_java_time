package com.modusoftware.exerciseReadFileAPI.business.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class EmployeeDTO {
	
	String nombre;
	String apellido;
	String genero;
    LocalDate fecha_de_nacimiento;
	String cargo;
	String antiguedad;
	String fechaIngreso;
	


	public EmployeeDTO(String nombre, String apellido, String genero,  LocalDate fecha_de_nacimiento ,
		 String cargo, String antiguedad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.genero = genero;
		this.fecha_de_nacimiento = fecha_de_nacimiento;
		this.cargo = cargo;
		this.antiguedad = antiguedad;
	}
	
	public EmployeeDTO(String nombre, String apellido, String genero,  LocalDate fecha_de_nacimiento ,
			 String cargo, String antiguedad,String fechaIngreso) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.genero = genero;
			this.fecha_de_nacimiento = fecha_de_nacimiento;
			this.cargo = cargo;
			this.antiguedad = antiguedad;
			this.fechaIngreso = fechaIngreso;
		}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getGenero() {
		return genero;
	}



	public void setGenero(String genero) {
		this.genero = genero;
	}



	public LocalDate getFecha_de_nacimiento() {
		return fecha_de_nacimiento;
	}



	public void setFecha_de_nacimiento(LocalDate fecha_de_nacimiento) {
		this.fecha_de_nacimiento = fecha_de_nacimiento;
	}



	public String getCargo() {
		return cargo;
	}



	public void setCargo(String cargo) {
		this.cargo = cargo;
	}



	public String getAntiguedad() {
		return antiguedad;
	}



	public void setAntiguedad(String antiguedad) {
		this.antiguedad = antiguedad;
	}

	public String getFechaIngreso() {
		return fechaIngreso;
	}



	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	
	
	

}
