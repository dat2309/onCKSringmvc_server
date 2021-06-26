package com.se.onck3.dao;

import java.util.List;

import com.se.onck3.entity.CreditCard;

public interface CreditCardDAO {
	public List<CreditCard> getCreditCards();
	public CreditCard getCreditCard(int id);
	public void deleteCreditCard(int id);
	public void saveCreditCard(CreditCard creditCard, int personId);

}
