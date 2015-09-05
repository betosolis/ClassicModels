package org.websamples.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.websamples.domain.Customer;

@Repository
@Transactional
public class CustomerDAOImpl implements CustomerDAO {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> getCustomers() {
		Query query = em.createNamedQuery("Customer.findAll");
		return query.getResultList();
	}

	@Override
	public Customer getCustomerById(int id) {
		Query query = em.createNamedQuery("Customer.findById");
		query.setParameter("id",id );
		return (Customer)query.getSingleResult();
	}

	@Override
	public void save(Customer customer) {
		em.persist( customer);
		em.flush();
		em.close();
	}

	@Override
	public void delete(int id) {
		Customer customer = em.find( Customer.class , id);
		em.remove(customer);
		em.flush();
		em.close();
	}
}
