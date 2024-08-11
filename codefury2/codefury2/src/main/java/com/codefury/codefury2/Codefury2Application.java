package com.codefury.codefury2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Codefury2Application {

	public static void main(String[] args) {
		SpringApplication.run(Codefury2Application.class, args);
	}

}
