package org.websamples.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import org.websamples.domain.Customer;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration( locations={"classpath:applicationDAO.xml"} )
@Transactional
@Rollback(value=true)
public class ContactInfoDAOTest {
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Test
	public void getContactsTest(){
		List<Customer> contacts = customerDAO.getCustomers();
		Assert.assertTrue( contacts.size() > 0 );
	}
	
	/*
	@Test
	public void saveContactTest(){
		
		Query query = em.createNamedQuery("Employee.findById");
		query.setParameter("id",1056);
		Employee employee = (Employee)query.getSingleResult();
		
		Customer customer = new Customer();
		
		customer.setCustomernumber(new Integer(497));
		customer.setEmployee(employee);
		customer.setCustomername("Kelly's Gift Shop");
		customer.setContactlastname("Snowden");
		customer.setContactfirstname("Tony");
		customer.setPhone("+64 9 5555500");
		customer.setAddressline1("Arenales 1938 3'A'");
		customer.setAddressline2("");
		customer.setCity("Auckland  ");
		customer.setState("");
		customer.setPostalcode("");
		customer.setCountry("New Zealand");
		customer.setCreditlimit(110000.00);

		customerDAO.save(customer);
		Assert.assertNotNull(customer.getCustomernumber());
	}

	

	@Test
	public void deleteContactTest(){
		int expected = customerDAO.getCustomers().size();
		customerDAO.delete(103);
		int size = customerDAO.getCustomers().size();
		Assert.assertNotEquals(size, expected);
	}
	*/
	@Test
	public void getContactByIdTest(){
		Customer customer = customerDAO.getCustomerById(103);
		Assert.assertNotNull(customer);
	}
	
	@Test
	public void updateContactTest(){
		Customer customer = customerDAO.getCustomerById(103);
		customer.setCustomername( "de la rosa" );
		customerDAO.save(customer);
		//Customer customer2 = customerDAO.getCustomerById(1l);
		Customer customer2 = customerDAO.getCustomerById(103);
		Assert.assertEquals("de la rosa",  customer2.getCustomername() );
	}
	

}
