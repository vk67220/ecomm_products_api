package in.ashokit.ecomm.mapper;

import org.modelmapper.ModelMapper;

import in.ashokit.ecomm.dto.ProductCategoryDto;
import in.ashokit.ecomm.entities.ProductCategory;

public class ProductCategoryMapper {

	public static final ModelMapper modelMapper = new ModelMapper();

	public static ProductCategoryDto convertToDTO(ProductCategory entity) {
		return modelMapper.map(entity, ProductCategoryDto.class);
	}

	public static ProductCategory convertToEntity(ProductCategoryDto categoryDto) {
		return modelMapper.map(categoryDto, ProductCategory.class);
	}

}
