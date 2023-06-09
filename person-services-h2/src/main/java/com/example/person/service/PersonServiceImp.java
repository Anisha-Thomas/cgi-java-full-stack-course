package com.example.person.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.person.model.Person;
import com.example.person.repository.PersonRepository;

@Service
public class PersonServiceImp implements PersonService {
	
	public final PersonRepository personRepository;
	

	public PersonServiceImp(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
	}


	@Override
	public List<Person> getAllPersons() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

}
