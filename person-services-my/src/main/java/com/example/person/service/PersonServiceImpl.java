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

	public Person updateByFirstName(String name) {
		return personRepository.updateByFirstName(name);

	}
}
