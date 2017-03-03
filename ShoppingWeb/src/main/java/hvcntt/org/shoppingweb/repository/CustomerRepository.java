package hvcntt.org.shoppingweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hvcntt.org.shoppingweb.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	public Customer findByFirstnameAndLastname(String firstname,String lastname);
	public List<Customer> findByLastname(String lastname);
}
