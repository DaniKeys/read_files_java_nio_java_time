package com.modusoftware.exerciseReadFileAPI;

import java.awt.geom.GeneralPath;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import com.modusoftware.exerciseReadFileAPI.api.execute.GenerateFile;
import com.modusoftware.exerciseReadFileAPI.business.service.ReadFilesService;


@SpringBootApplication
public class ExerciseReadFileApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseReadFileApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			ReadFilesService read = new ReadFilesService();
			String fileRead = "/home/danielcamacho/Escritorio/fileEmpleados";

			if (fileRead == "/home/danielcamacho/Escritorio/fileEmpleados") {
				read.leerArchivo(fileRead);
			} else {
				System.out.println("El archivo no existe");
			}
			
			
	
		};
	}
}
