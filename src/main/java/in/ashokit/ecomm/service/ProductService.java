package in.ashokit.ecomm.service;

import java.util.List;

import in.ashokit.ecomm.dto.ProductCategoryDto;
import in.ashokit.ecomm.dto.ProductDto;

public interface ProductService {

	public List<ProductCategoryDto> findAllCategories();

	public List<ProductDto> findProductsByCategoryId(Long categoryId);

	public ProductDto findByProductId(Long productId);

	public List<ProductDto> findByProductName(String productName);
}
