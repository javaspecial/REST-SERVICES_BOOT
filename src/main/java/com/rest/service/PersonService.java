package com.rest.service;

import java.util.Hashtable;

import org.springframework.stereotype.Service;

import com.rest.model.Person;

@Service
public class PersonService {
	Hashtable<String, Person> persons = new Hashtable<String, Person>();

	public PersonService() {
		Person person = new Person();
		person.setId("501");
		person.setAge(23);
		person.setFirstName("Md.");
		person.setLastName("Shadath");
		person.setDescription("Son of Mr. Sobahan");
		persons.put("son", person);

		person = new Person();
		person.setId("502");
		person.setAge(60);
		person.setFirstName("Mr.");
		person.setLastName("Sobahan");
		person.setDescription("Father of Md. Shadath");
		persons.put("father", person);
	}

	public Person getPerson(String id) {
		if (persons.containsKey(id))
			return persons.get(id);
		return null;
	}

	public Hashtable<String, Person> getAll() {
		return persons;
	}
}
