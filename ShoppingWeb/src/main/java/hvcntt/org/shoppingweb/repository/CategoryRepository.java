package hvcntt.org.shoppingweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import hvcntt.org.shoppingweb.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
	
}
