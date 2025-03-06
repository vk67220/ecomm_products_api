package in.ashokit.ecomm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.ecomm.entities.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

	// select * from products where category_id = :categoryId
	public List<Product> findByCategoryId(Long categoryId);

	// select * from products where name like '%name%'
	public List<Product> findByNameContaining(String productName);

}
