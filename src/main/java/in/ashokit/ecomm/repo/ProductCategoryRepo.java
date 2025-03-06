package in.ashokit.ecomm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.ecomm.entities.ProductCategory;

public interface ProductCategoryRepo extends JpaRepository<ProductCategory, Long>{

}
