package com.example.person.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	public final PersonRepository personRepository;

	public PersonServiceImpl(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}

	public Person createPerson(Person person) {
		return personRepository.createPerson(person);

	}

	public Collection<Person> getAllPersons() {
		return personRepository.getAllPersons();

	}

	public Person getPeresonByIdPerson(Integer personId) {
		return personRepository.getPeresonByIdPerson(personId);

	}

	public Person updatePersonById(Integer personId, Person person) {

		return personRepository.updatePersonById(personId, person);

	}

	public Person findByFirstName(String name) {
		return personRepository.findByFirstName(name);

	}

	public Person updateByFirstName(String name, Person person) {
		return personRepository.updateByFirstName(name, person);

	}

	public Person findByLastName(String name) {
		return personRepository.findByLastName(name);

	}

	public Person updateByLastName(String name, Person person) {
		return personRepository.updateByLastName(name, person);

	}

	public Person findByEmail(String email) {
		return personRepository.findByEmail(email);

	}

	public Person updateByEmail(String email, Person person) {
		return personRepository.updateByEmail(email, person);

	}
}
