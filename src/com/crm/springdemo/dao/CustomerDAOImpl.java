package com.crm.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.crm.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomers() {

		Session session = sessionFactory.getCurrentSession();

		Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		
		session.saveOrUpdate(customer);
	}

	@Override
	public Customer getCustomers(int id) {

		Session session = sessionFactory.getCurrentSession();
		
		Customer customer = session.get(Customer.class, id);
		
		return customer;
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("delete from Customer where id=:theId");
		
		query.setParameter("theId", id);
		
		query.executeUpdate();
	}

	@Override
	public List<Customer> searchCustomer(String name) {

		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(name!=null && name.trim().length() > 0) {
			query = session.createQuery("from Customer where lower(firstName) like :theName or lower(lastName) like :theName");
			query.setParameter("theName", "%"+name.toLowerCase()+"%");
		}
		else {
			query = session.createQuery("from Customer");
		}
		
		List<Customer> customers = query.getResultList();
		
		return customers;
	}

}
