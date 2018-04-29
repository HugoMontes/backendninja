package com.udemi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.udemi.model.Person;
import com.udemi.service.ExampleService;

@Service("exampleService")
public class ExampleServiceImpl implements ExampleService {
	
	private static Log LOG=LogFactory.getLog(ExampleServiceImpl.class);

	@Override
	public List<Person> getListPeople() {
		// El codigo de este metodo fue extraido del metodo getPeople
		// de la clase ExampleController
		List<Person> people = new ArrayList<>();
		people.add(new Person("Juan", 25));
		people.add(new Person("Ana", 30));
		people.add(new Person("Eva", 42));
		people.add(new Person("Piter", 27));
		LOG.info("HELLO FROM SERVICE");
		return people;
	}
	
}
