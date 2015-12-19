package com.pruebaServicios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static final int IVA = 21;
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}