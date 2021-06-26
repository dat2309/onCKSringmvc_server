package com.se.onck3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.onck3.entity.Person;


@Repository
public class PersonDAOImpl implements PersonDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Person> getPersons() {
		Session session = sessionFactory.getCurrentSession();
		Query<Person> query = session.createQuery("from Person order by lastName", Person.class);
		List<Person> list = query.getResultList();
		return list;
	}

	@Override
	public Person getPerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person p = session.get(Person.class, id); 
		return p;
	}

	@Override
	public void deletePerson(int id) {
		Session session = sessionFactory.getCurrentSession();
		Person p = session.get(Person.class, id); 
		session.delete(p);
		
	}

	@Override
	public void savePerson(Person person) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(person);
		
	}

}
