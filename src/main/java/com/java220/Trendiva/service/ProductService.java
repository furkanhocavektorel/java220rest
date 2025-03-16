package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.request.ProductSaveRequestDto;
import com.java220.Trendiva.entity.Category;
import com.java220.Trendiva.entity.Product;
import com.java220.Trendiva.exception.custom.CategoryException;
import com.java220.Trendiva.repository.ICategoryRepository;
import com.java220.Trendiva.repository.IProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final IProductRepository repository;
    private final CategoryService categoryService;


    public void save(ProductSaveRequestDto dto){

        Category category = categoryService.findById(dto.getCategoryId()).orElseThrow(()-> new CategoryException("category bulunamadi"));

        Product product= new Product();

        product.setBrand(dto.getBrand());
        product.setPrice(dto.getPrice());
        product.setName(dto.getName());

        product.setCategory(category);

        repository.save(product);


    }



}
