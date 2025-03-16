package com.java220.Trendiva.mapper;

import com.java220.Trendiva.dto.request.ProductSaveRequestDto;
import com.java220.Trendiva.dto.response.ProductResponseDto;
import com.java220.Trendiva.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper( ProductMapper.class );

    @Mapping(target = "category.id" , source = "categoryId")
    Product toProduct(ProductSaveRequestDto dto);


    @Mapping(target = "productName" , source = "name")
    ProductResponseDto toDto(Product product);

}
