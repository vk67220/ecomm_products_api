package in.ashokit.ecomm.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.ecomm.dto.ProductCategoryDto;
import in.ashokit.ecomm.dto.ProductDto;
import in.ashokit.ecomm.mapper.ProductCategoryMapper;
import in.ashokit.ecomm.mapper.ProductMapper;
import in.ashokit.ecomm.repo.ProductCategoryRepo;
import in.ashokit.ecomm.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepo productRepo;
	
	@Autowired
	private ProductCategoryRepo categoryRepo;

	@Override
	public List<ProductCategoryDto> findAllCategories() {		
		
		/*
		
		List<ProductCategory> categories = categoryRepo.findAll();
		
		List<ProductCategoryDto> dtoList = new ArrayList<>();
		for(ProductCategory category : categories) {
			ProductCategoryDto dto = ProductCategoryMapper.convertToDTO(category);
			dtoList.add(dto);			
		}
		
		return dtoList;
		
		*/
		
		 return categoryRepo.findAll()
							.stream()
							.map(ProductCategoryMapper::convertToDTO)
							.collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> findProductsByCategoryId(Long categoryId) {
		
		return productRepo.findByCategoryId(categoryId)
						   .stream()
						   .map(ProductMapper::convertToDTO)
						   .collect(Collectors.toList());
	}

	@Override
	public ProductDto findByProductId(Long productId) {
		
		/*
		Optional<Product> byId = productRepo.findById(productId);
		
		if(byId.isPresent()) {
			Product product = byId.get();
			return ProductMapper.convertToDTO(product);
		}
		
		return null;
		*/
		
		return productRepo.findById(productId)
				          .map(ProductMapper::convertToDTO)
				          .orElse(null);
	}

	@Override
	public List<ProductDto> findByProductName(String productName) {
		
		return productRepo.findByNameContaining(productName)
						  .stream()
						  .map(ProductMapper::convertToDTO)
						  .collect(Collectors.toList());
	}

}
