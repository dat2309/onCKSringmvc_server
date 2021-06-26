package com.se.onck3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.se.onck3.dao.CreditCardDAO;
import com.se.onck3.entity.CreditCard;

@Service
public class CreditCardServiceImpl implements CreditCardService{
	@Autowired
	private CreditCardDAO creditCardDAO;

	@Override
	@Transactional
	public List<CreditCard> getCreditCards() {
		// TODO Auto-generated method stub
		return creditCardDAO.getCreditCards();
	}

	@Override
	@Transactional
	public CreditCard getCreditCard(int id) {
		// TODO Auto-generated method stub
		return creditCardDAO.getCreditCard(id);
	}

	@Override
	@Transactional
	public void deleteCreditCard(int id) {
		// TODO Auto-generated method stub
		creditCardDAO.deleteCreditCard(id);
		
	}

	@Override
	@Transactional
	public void saveCreditCard(CreditCard creditCard, int personId) {
		// TODO Auto-generated method stub
		creditCardDAO.saveCreditCard(creditCard, personId);
		
	}

}
