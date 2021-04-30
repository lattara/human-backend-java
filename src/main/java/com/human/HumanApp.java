package com.human;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HumanApp {

	public static void main(String[] args) {
		SpringApplication.run(HumanApp.class, args);
	}

}
