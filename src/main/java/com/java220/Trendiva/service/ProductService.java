package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.request.ProductSaveRequestDto;
import com.java220.Trendiva.dto.response.ProductResponseDto;
import com.java220.Trendiva.entity.Category;
import com.java220.Trendiva.entity.Product;
import com.java220.Trendiva.exception.custom.CategoryException;
import com.java220.Trendiva.mapper.ProductMapper;
import com.java220.Trendiva.repository.ICategoryRepository;
import com.java220.Trendiva.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository repository;
    private final CategoryService categoryService;


    public void save(ProductSaveRequestDto dto){

        Category category = categoryService.findById(dto.getCategoryId()).orElseThrow(()-> new CategoryException("category bulunamadi",5001));
        Product product= ProductMapper.INSTANCE.toProduct(dto);
        repository.save(product);
    }


    public List<ProductResponseDto> findAll() {
        List<ProductResponseDto> dtos= new ArrayList<>();

        for (Product product : repository.findAll()){

            ProductResponseDto dto = ProductMapper.INSTANCE.toDto(product);

            dtos.add(dto);
        }


        return dtos;
    }



}
