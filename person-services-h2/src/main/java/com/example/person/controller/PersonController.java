package com.example.person.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@RestController
public class PersonController {

	public final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/persons")
	public ResponseEntity<Collection<Person>> getAllPersons() {

		return ResponseEntity.ok(personService.getAllPersons());

	}
}
