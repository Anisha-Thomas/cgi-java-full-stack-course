package com.example.person;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@SpringBootApplication
public class PersonServicesH2Application implements CommandLineRunner {

	public final PersonRepository personReposity;
	
	public PersonServicesH2Application(PersonRepository personReposity) {
		super();
		this.personReposity = personReposity;
	}

	public static void main(String[] args) {
		SpringApplication.run(PersonServicesH2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		personReposity.save(new Person(1,"Ammu","Issac","ammuissac@gmail.com"));
		personReposity.save(new Person(2,"Saneesha","Thomas","saneesha@gmail.com"));
		
	}

}
