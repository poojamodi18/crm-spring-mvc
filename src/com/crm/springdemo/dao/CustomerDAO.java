package com.crm.springdemo.dao;

import java.util.List;

import com.crm.springdemo.entity.Customer;

public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomers(int id);

	public void deleteCustomer(int id);

	public List<Customer> searchCustomer(String name);
}
