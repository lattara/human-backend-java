package com.human;

import com.human.users.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories ()
public class HumanApp {

	public static void main(String[] args) {
		SpringApplication.run(HumanApp.class, args);
	}

}
