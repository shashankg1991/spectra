package com.spectra.jewel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableAutoConfiguration
@ImportResource("classpath:integration-config.xml")
public class JewelApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewelApplication.class, args);
	}

}
