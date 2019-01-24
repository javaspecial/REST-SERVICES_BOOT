package com.rest.controller;

import java.util.Hashtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.model.Person;
import com.rest.service.PersonService;

@RestController
@RequestMapping("/api")
public class PersonController {
	@Autowired
	PersonService personService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	@ResponseBody
	public String getAll() throws JsonProcessingException {
		return convertToJson(personService.getAll());
	}

	private String convertToJson(Hashtable<String, Person> all) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(all);
		System.out.println(json);
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(all);
		System.out.println(json);
		return json;
	}

	@RequestMapping("{id}")
	public String getPerson(@PathVariable("id") String id) throws JsonProcessingException {
		return convertToJson(personService.getPerson(id));
	}

	private String convertToJson(Person person) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(person);
		System.out.println(json);
		json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);
		System.out.println(json);
		return json;
	}
}
