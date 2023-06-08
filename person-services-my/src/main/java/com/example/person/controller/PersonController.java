package com.example.person.controller;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.person.model.Person;
import com.example.person.service.PersonService;

@RestController
public class PersonController {

	private PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@PostMapping("/person")
	public ResponseEntity<Person> createPerson(@RequestBody Person person) {
		Person p = personService.createPerson(person);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}

	@GetMapping("/person")
	public ResponseEntity<Collection<Person>> getPerson() {
		return ResponseEntity.ok().body(personService.getAllPersons());
	}

	@GetMapping("/person/{personId}")
	public ResponseEntity<?> getPersonById(@PathVariable("personId") Integer personid) {
		Person p = personService.getPeresonByIdPerson(personid);
		System.out.println(p);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personid + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.FOUND).body(p);
		}
	}

	@PutMapping("/person/{personId}")
	public ResponseEntity<?> updatePerson(@PathVariable("personId") Integer personId, @RequestBody Person person) {
		Person p = personService.updatePersonById(personId, person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("person with id: " + personId + " not found");
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(p);
		}

	}

	@GetMapping("/person/firstname/{firstName}")
	public ResponseEntity<?> getPersonByFirstName(@PathVariable("firstName") String firstName) {
		Person p = personService.findByFirstName(firstName);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the first name " + firstName + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	@PutMapping("/person/firstname/{firstName}")
	public ResponseEntity<?> updateByFirstName(@PathVariable("firstName") String firstName,@RequestBody Person person) {
		Person p = personService.updateByFirstName(firstName,person);
		System.out.println("First Name" +firstName);
		System.out.println("New First Name "+person.getFirstName());
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the first name " + firstName + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	@GetMapping("/person/lastname/{lastName}")
	public ResponseEntity<?> getPersonByLastName(@PathVariable("lastName") String lastName) {
		Person p = personService.findByLastName(lastName);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the last name " + lastName + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	@PutMapping("/person/lastname/{lastName}")
	public ResponseEntity<?> updateByLastName(@PathVariable("email") String lastName,@RequestBody Person person) {
		Person p = personService.updateByLastName(lastName,person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the first name " + lastName + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	@GetMapping("/person/email/{email}")
	public ResponseEntity<?> getPersonByEmail(@PathVariable("email") String email) {
		Person p = personService.findByEmail(email);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the Email " + email + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	@PutMapping("/person/email/{email}")
	public ResponseEntity<?> updateByEmail(@PathVariable("email") String email,@RequestBody Person person) {
		Person p = personService.updateByEmail(email,person);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body("person with the email " + email + " not found");
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
}
