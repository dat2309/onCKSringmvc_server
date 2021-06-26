package com.se.onck3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.se.onck3.entity.CreditCard;

@Repository
public class CreditCardDAOImpl implements CreditCardDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CreditCard> getCreditCards() {
		Session session = sessionFactory.getCurrentSession();
		Query<CreditCard> query = session.createQuery("from CreditCard order by type", CreditCard.class);
		List<CreditCard> list = query.getResultList();
		return list;
	}

	@Override
	public CreditCard getCreditCard(int id) {
		Session session = sessionFactory.getCurrentSession();
		CreditCard c = session.get(CreditCard.class, id); 
		return c;
	}

	@Override
	public void deleteCreditCard(int id) {
		Session session = sessionFactory.getCurrentSession();
		CreditCard c = session.get(CreditCard.class, id);
		session.delete(c);
		
	}

	@Override
	public void saveCreditCard(CreditCard creditCard, int personId) {
		Session session = sessionFactory.getCurrentSession();
		session.save(creditCard);
		
	}

}
