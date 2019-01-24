package com.rest.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.Person;
import com.rest.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public Hashtable<String, Person> getAll() {
		return personService.getAll();
	}

	@RequestMapping("{id}")
	public Person getPerson(@PathVariable("id") String id) {
		return personService.getPerson(id);
	}
}
