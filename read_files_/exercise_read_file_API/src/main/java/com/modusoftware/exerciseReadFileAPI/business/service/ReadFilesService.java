package com.modusoftware.exerciseReadFileAPI.business.service;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import com.modusoftware.exerciseReadFileAPI.api.execute.GenerateFile;
import com.modusoftware.exerciseReadFileAPI.business.dto.EmployeeDTO;
import com.modusoftware.exerciseReadFileAPI.persistent.dao.EmployeeDAO;


public class ReadFilesService {
	
	
	 public void leerArchivo(String filePpal) {
		 
		 List<String> empleados = new ArrayList<>();
		 
				try {
					empleados = Files.readAllLines(Paths.get(filePpal),StandardCharsets.UTF_8);
				} catch (IOException e) {

				}
		
		List<String[]> emp = empleados.stream()
		                             .map(x -> x.split("\\|"))
		                             .collect(Collectors.toList());
		
		List<EmployeeDAO> listEmp = new ArrayList<>();
		
		for(int i = 0; i < emp.size(); i++) {
			EmployeeDAO empleado = new EmployeeDAO(emp.get(i)[0],emp.get(i)[1],emp.get(i)[2],emp.get(i)[3],emp.get(i)[4],emp.get(i)[5]);
			listEmp.add(empleado);
		}
		
		
		List<LocalDate> date = listEmp.stream()
		                              .map(x -> {
		                            	 DateTimeFormatter formatDateAMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		                            	 return LocalDate.parse(x.getFecha_de_nacimiento(), formatDateAMD);
		                              })
		                              .collect(Collectors.toList());
		
		List<EmployeeDTO> listDTO = new ArrayList<>();  
		
		for(int j = 0; j < emp.size(); j++) {
			EmployeeDTO dto = new EmployeeDTO(emp.get(j)[0],emp.get(j)[1],emp.get(j)[2],date.get(j),emp.get(j)[4],emp.get(j)[5]);
			listDTO.add(dto);
		}
			
		List<EmployeeDTO>listMale = listDTO.stream()
				         				   .filter(x -> x.getGenero().startsWith("M"))
				         				   .collect(Collectors.toList());
		
		List<EmployeeDTO>listFemale = listDTO.stream()
				   							 .filter(x -> x.getGenero().startsWith("F"))
				                             .collect(Collectors.toList());
		
		String formato = ".txt";
		String ruta2 = "/home/danielcamacho/Escritorio/fileEmpleados_F" + formato;
		String ruta3 = "/home/danielcamacho/Escritorio/fileEmpleados_M" + formato;
		
		GenerateFile.escribirArchivoEF(ruta2, listFemale);
		GenerateFile.escribirArchivoEM(ruta3, listMale);
		
		DateTimeFormatter formatDateDMA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		List<LocalDate> dma = listDTO.stream()
						             .map(x -> {
						         		String fechaDeNacimientoDMA = formatDateDMA.format(x.getFecha_de_nacimiento());
						         		return fechaDeNacimientoDMA;
						              })
						             .map(x -> LocalDate.parse(x, formatDateDMA))
						             .collect(Collectors.toList());
		
		List<EmployeeDTO> listOrder = new ArrayList<>();  
		
		for(int j = 0; j < emp.size(); j++) {
			EmployeeDTO dto = new EmployeeDTO(emp.get(j)[0],emp.get(j)[1],emp.get(j)[2],dma.get(j),emp.get(j)[4],emp.get(j)[5]);
			listOrder.add(dto);
		}
		Collections.sort(listOrder, (o1, o2) -> o1.getNombre().compareTo(o2.getNombre()));
		
		String ruta4 = "/home/danielcamacho/Escritorio/fileEmpleados_OrderAsc";
	    GenerateFile.escribirArchivoOrderAsc(ruta4, listOrder);
	    
		LocalDate fechaActual = LocalDate.now();
		
		List<EmployeeDTO> mayorAge = listDTO.stream()
								             .filter(x -> {
								    			Period mayores = Period.between(x.getFecha_de_nacimiento(), fechaActual);
								    			return mayores.getYears() >= 18;
								    		 })
								             .sorted((x,y) -> x.getFecha_de_nacimiento().compareTo(y.getFecha_de_nacimiento()))
								             .collect(Collectors.toList());
		
		String ruta5 = "/home/danielcamacho/Escritorio/fileEmpleados_MayorAge";

		GenerateFile.escribirArchivoMayorEdad(ruta5, mayorAge);
		
		
		DateTimeFormatter formatDateAMD = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		DateTimeFormatter formatDateM = DateTimeFormatter.ofPattern("MM/yyyy");
		
		List<String> obtFechaIngreso = listOrder.stream()
												 .map(x -> {
													Period meses = Period.ofMonths(Integer.parseInt(x.getAntiguedad()));
													LocalDate fechaIngreso = fechaActual.minus(meses);
													String output = formatDateM.format(fechaIngreso);
//													LocalDate cast = LocalDate.parse(output, formatDateM);
													return output;
													})
//												 .map(x -> LocalDate.parse(x, formatDateM))
												 .collect(Collectors.toList());
		
		List<EmployeeDTO> listDate = new ArrayList<>();
		for(int j = 0; j < emp.size(); j++) {
			EmployeeDTO dto = new EmployeeDTO(emp.get(j)[0],emp.get(j)[1],emp.get(j)[2],date.get(j),emp.get(j)[4],emp.get(j)[5],obtFechaIngreso.get(j));
			listDate.add(dto);
		}
		
			    
		 	List<EmployeeDTO> empleadosCargosAuxiliares =	listDate.stream()
											.filter(x ->  x.getCargo().contains("Auxiliar"))
											.collect(Collectors.toList());
		 
			List<EmployeeDTO> empleadosCargosDirecivos = listDate.stream()
											.filter(x ->  x.getCargo().contains("Director"))
											.collect(Collectors.toList());
										
			List<EmployeeDTO> empleadosCargosGerenciales = listDate.stream()
											.filter(x ->  x.getCargo().contains("Gerente"))
											.collect(Collectors.toList());

			String rutaConcat = "/home/danielcamacho/Escritorio/";
			LocalDateTime fechaHoraActual = LocalDateTime.now();
			DateTimeFormatter formatDateTime = DateTimeFormatter.ofPattern("yyyyMMddhhmmss");
			String fechaArchivo = formatDateTime.format(fechaHoraActual);
		
			String ruta6 = rutaConcat + "auxiliares" + "_" + fechaArchivo + formato;
			String ruta7 = rutaConcat + "directores" + "_" + fechaArchivo + formato;
			String ruta8 = rutaConcat + "gerentes" + "_" + fechaArchivo + formato;

			GenerateFile.escribirArchivoAuxiliares(ruta6, empleadosCargosAuxiliares);
			GenerateFile.escribirArchivoDirectores(ruta7, empleadosCargosDirecivos);
			GenerateFile.escribirArchivoGerentes(ruta8, empleadosCargosGerenciales);
	 }

}
