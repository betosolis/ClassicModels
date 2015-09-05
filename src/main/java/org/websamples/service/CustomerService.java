package org.websamples.service;

import java.util.List;

import org.websamples.domain.Customer;

public interface CustomerService {
	
	
	List<Customer> getContacts();
	
	Customer getCustomerById( int id );

}
