package com.se.onck3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.onck3.dao.PersonDAO;
import com.se.onck3.entity.Person;

@Service
public class PersonServiceImpl implements PersonService{
	@Autowired
	private PersonDAO personDAO;

	@Override
	@Transactional
	public List<Person> getPersons() {
		// TODO Auto-generated method stub
		return personDAO.getPersons();
	}

	@Override
	@Transactional
	public Person getPerson(int id) {
		// TODO Auto-generated method stub
		return personDAO.getPerson(id);
	}

	@Override
	@Transactional
	public void deletePerson(int id) {
		personDAO.deletePerson(id);
		
	}

	@Override
	@Transactional
	public void savePerson(Person person) {
		personDAO.savePerson(person);
		
	}

}
