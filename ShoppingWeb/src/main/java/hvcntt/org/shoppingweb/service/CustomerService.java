package hvcntt.org.shoppingweb.service;

import java.util.List;

import hvcntt.org.shoppingweb.model.Customer;

public interface CustomerService {
	public List<Customer> getAll();
	public Customer create(Customer customer);
	public Customer findByName(String firstname,String lastname);
	public List<Customer> findByLastname(String lastname);
}
