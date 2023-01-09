package com.project.ey.bluepy.transfer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BluepyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BluepyApplication.class, args);
	}

}
