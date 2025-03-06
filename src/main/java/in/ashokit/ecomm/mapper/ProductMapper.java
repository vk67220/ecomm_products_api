package in.ashokit.ecomm.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.ecomm.dto.ProductDto;
import in.ashokit.ecomm.entities.Product;

public class ProductMapper {

	public static final ModelMapper modelMapper = new ModelMapper();

	public static ProductDto convertToDTO(Product entity) {
		return modelMapper.map(entity, ProductDto.class);
	}

	public static Product convertToEntity(ProductDto productDto) {
		return modelMapper.map(productDto, Product.class);
	}

}
