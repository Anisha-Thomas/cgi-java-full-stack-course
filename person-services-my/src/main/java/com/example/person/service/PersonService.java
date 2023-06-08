package com.example.person.service;

import java.util.Collection;

import com.example.person.model.Person;


public interface PersonService {
	
	public Person createPerson(Person person);

	public Collection<Person> getAllPersons();

	public Person getPeresonByIdPerson(Integer personId);

	public Person updatePersonById(Integer personId, Person person);

	public Person findByFirstName(String name);

	public Person updateByFirstName(String name, Person person);

	public Person findByLastName(String lastName);

	public Person updateByLastName(String lastName, Person person);

	public Person findByEmail(String email);

	public Person updateByEmail(String email, Person person);
}
