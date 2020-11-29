package com.youtube.myslipp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class MySlippApplication {

	public static void main(String[] args) {
		SpringApplication.run(MySlippApplication.class, args);
	}

}
