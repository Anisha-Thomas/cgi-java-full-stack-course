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
	public Person updateByFirstName(String name, Person newperson) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		System.out.println("Updated " + personlist);
		for (Person person : personlist) {
			if (person.getFirstName().equals(name)) {
				tempPerson = person;
				System.out.println("Old" + tempPerson.getFirstName());
				System.out.println("New Name " + newperson.getFirstName());
				tempPerson.setFirstName(newperson.getFirstName());
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person findByLastName(String name) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		for (Person person : personlist) {
			if (person.getLastName().equals(name)) {
				tempPerson = person;
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person findByEmail(String email) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		for (Person person : personlist) {
			if (person.getEmail().equals(email)) {
				tempPerson = person;
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person updateByEmail(String name, Person newperson) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		System.out.println("Updated " + personlist);
		for (Person person : personlist) {
			if (person.getEmail().equals(name)) {
				tempPerson = person;
				System.out.println("Old" + tempPerson.getFirstName());
				System.out.println("New Name " + newperson.getFirstName());
				tempPerson.setEmail(newperson.getEmail());
				break;
			}
		}
		return tempPerson;
	}

	@Override
	public Person updateByLastName(String name, Person newperson) {
		Person tempPerson = null;
		Collection<Person> personlist = persons.values();
		System.out.println("Updated " + personlist);
		for (Person person : personlist) {
			if (person.getLastName().equals(name)) {
				tempPerson = person;
				System.out.println("Old" + tempPerson.getFirstName());
				System.out.println("New Name " + newperson.getFirstName());
				tempPerson.setLastName(newperson.getLastName());
				break;
			}
		}
		return tempPerson;
	}

}
