package com.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class App1SchoolmanagementsystemApplication  extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(App1SchoolmanagementsystemApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(App1SchoolmanagementsystemApplication.class, args);
	}

}
