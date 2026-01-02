package com.food_app.FeedLine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class FeedLineApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeedLineApplication.class, args);
	}

}
