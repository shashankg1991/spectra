package com.spectra.jewel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.spectra.jewel.repository")
@EntityScan("com.spectra.jewel.model")
@ComponentScan(basePackages = "com.spectra.jewel")
@EnableAutoConfiguration
public class JewelApplication {

	public static void main(String[] args) {
		SpringApplication.run(JewelApplication.class, args);
	}

}
