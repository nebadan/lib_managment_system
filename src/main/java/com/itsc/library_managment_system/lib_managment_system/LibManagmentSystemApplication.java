package com.itsc.library_managment_system.lib_managment_system;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import com.itsc.library_managment_system.lib_managment_system.model.Book;

import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class LibManagmentSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibManagmentSystemApplication.class, args);
	}

}
