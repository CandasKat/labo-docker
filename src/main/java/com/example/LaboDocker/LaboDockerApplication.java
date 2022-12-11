package com.example.LaboDocker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LaboDockerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaboDockerApplication.class, args);
	}

}
