package in.ashokit.ecomm.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.ecomm.dto.ProductCategoryDto;
import in.ashokit.ecomm.dto.ProductDto;
import in.ashokit.ecomm.response.ApiResponse;
import in.ashokit.ecomm.service.ProductService;

@RestController
@CrossOrigin
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@GetMapping("/categories")
	public ResponseEntity<ApiResponse<List<ProductCategoryDto>>> productCategories() {
		ApiResponse<List<ProductCategoryDto>> response = new ApiResponse<>();
		List<ProductCategoryDto> allCategories = productService.findAllCategories();
		if (!allCategories.isEmpty()) {
			response.setStatus(200);
			response.setMessage("Fetched Categories successfully");
			response.setData(allCategories); // payload
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus(500);
			response.setMessage("Failed to fetch categories");
			response.setData(null); // no payload
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/products/{categoryId}")
	public ResponseEntity<ApiResponse<List<ProductDto>>> products(@PathVariable Long categoryId) {
		ApiResponse<List<ProductDto>> response = new ApiResponse<>();
		List<ProductDto> products = productService.findProductsByCategoryId(categoryId);
		if (!products.isEmpty()) {
			response.setStatus(200);
			response.setMessage("Fetched Products Succesfully");
			response.setData(products);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus(200);
			response.setMessage("No products");
			response.setData(Collections.emptyList()); // no payload
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
	}

	@GetMapping("/productsByName/{name}")
	public ResponseEntity<ApiResponse<List<ProductDto>>> products(@PathVariable String name) {
		ApiResponse<List<ProductDto>> response = new ApiResponse<>();
		System.out.println("Search Keyword :: " + name);
		List<ProductDto> products = productService.findByProductName(name);
		if (!products.isEmpty()) {
			response.setStatus(200);
			response.setMessage("Fetched Products Succesfully");
			response.setData(products);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus(500);
			response.setMessage("Failed to fetch products");
			response.setData(null); // no payload
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/product/{productId}")
	public ResponseEntity<ApiResponse<ProductDto>> product(@PathVariable Long productId) {
		ApiResponse<ProductDto> response = new ApiResponse<>();
		ProductDto product = productService.findByProductId(productId);
		if (product != null) {
			response.setStatus(200);
			response.setMessage("Fetched Product Succesfully");
			response.setData(product);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus(500);
			response.setMessage("Failed to fetch product");
			response.setData(null); // no payload
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
