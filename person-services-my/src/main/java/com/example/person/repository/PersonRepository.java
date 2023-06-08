package com.example.person.repository;

import java.util.Collection;

import com.example.person.model.Person;

public interface PersonRepository {
	public Person createPerson(Person person);

	public Collection<Person> getAllPersons();

	public Person getPeresonByIdPerson(Integer personId);

	public Person updatePersonById(Integer personId, Person person);

	public Person findByFirstName(String name);

	public Person updateByFirstName(String name);
}
