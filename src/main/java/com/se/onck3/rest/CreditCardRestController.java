package com.se.onck3.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.se.onck3.entity.CreditCard;

import com.se.onck3.service.CreditCardService;

@RestController
@RequestMapping("/api")
public class CreditCardRestController {
	@Autowired
	private CreditCardService creditCardService;
	
	@GetMapping("/creditcards")
	public List<CreditCard> getCreditCards(){
		List<CreditCard> list = creditCardService.getCreditCards();
		return list;
	}
	
	@DeleteMapping("/creditcards/{creditCardId}")
	public String deletePerson(@PathVariable("creditCardId") int creditCardId){
		CreditCard c = creditCardService.getCreditCard(creditCardId);
		if(c == null) {
			throw new RuntimeException("Credit card not found :"+ creditCardId);
		}
		creditCardService.deleteCreditCard(creditCardId);
		return "Delete credit card id: "+creditCardId;
		
	}
	
	@PostMapping("/creditcards")
	public CreditCard addCreditCards(@RequestBody CreditCard creditCard){
		creditCard.setId(0);
		creditCardService.saveCreditCard(creditCard, 0);
		return creditCard;
	}
	
	@PutMapping("/creditcards")
	public CreditCard updateCreditCards(@RequestBody CreditCard creditCard){
		creditCardService.saveCreditCard(creditCard, 0);
		return creditCard;
	}
	
	@GetMapping("/creditcards/{creditCardId}")
	public CreditCard getCreditCards(@PathVariable("creditCardId") int creditCardId){
		CreditCard c = creditCardService.getCreditCard(creditCardId);
		if(c == null) {
			throw new RuntimeException("Credit card not found: "+ creditCardId);
		}
		return c;
	}
	
	

}
