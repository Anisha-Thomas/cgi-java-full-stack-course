package com.example.person.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.person.model.Person;

@Repository
public class PersonRepositoryImp implements PersonRepository {

	private Map<Integer, Person> persons = null;

	{
		persons = new HashMap<Integer, Person>();
	}

	@Override
	public Person createPerson(Person person) {
		persons.put(person.getPersonId(), person);
		return person;
	}

	@Override
	public Collection<Person> getAllPersons() {
		System.out.println(persons);
		return persons.values();
	}

	@Override
	public Person getPeresonByIdPerson(Integer personId) {
		Person thePerson = persons.get(personId);
		System.out.println(thePerson);
		if (thePerson == null) {
			return null;
		}
		return thePerson;
	}

	@Override
	public Person updatePersonById(Integer personId, Person person) {

		Person thePerson = persons.get(personId);
		if (thePerson == null) {
			return null;
		} else {
			thePerson.setFirstName(person.getFirstName());
			thePerson.setLastName(person.getLastName());
			thePerson.setEmail(person.getEmail());
		}
		return thePerson;
	}

	@Override
	public Person findByFirstName(String name) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		for (Person person : personlist) {
			if (person.getFirstName().equals(name)) {
				tempPerson = person;
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person updateByFirstName(String name) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		for (Person person : personlist) {
			if (person.getFirstName().equals(name)) {
				tempPerson = person;
				tempPerson.setFirstName(name);
				break;
			}
		}
		return tempPerson;
	}

}
