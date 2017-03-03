package hvcntt.org.shoppingweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import hvcntt.org.shoppingweb.model.Image;
import hvcntt.org.shoppingweb.model.Product;

public interface ImageRepository extends JpaRepository<Image, Integer> {
	List<Image> findByProduct(Product product);
}
