package com.se.onck3.service;

import java.util.List;

import com.se.onck3.entity.Person;

public interface PersonService {
	public List<Person> getPersons();
	public Person getPerson(int id);
	public void deletePerson(int id);
	public void savePerson(Person person);

}
