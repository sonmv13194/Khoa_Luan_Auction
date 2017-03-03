package hvcntt.org.shoppingweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hvcntt.org.shoppingweb.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
