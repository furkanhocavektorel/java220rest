package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.response.CategoryResponseDto;
import com.java220.Trendiva.dto.request.CategorySaveRequestDto;
import com.java220.Trendiva.entity.Category;
import com.java220.Trendiva.repository.ICategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final ICategoryRepository repository;


    public void save(CategorySaveRequestDto dto){

        Category category= new Category();
        category.setName(dto.getName());

        repository.save(category);

    }

    public List<CategoryResponseDto> findAll() {
        List<Category> categories=repository.findAll();

        List<CategoryResponseDto> dtos= new ArrayList<>();

        for (Category category : categories){
            CategoryResponseDto dto= new CategoryResponseDto();
            dto.setName(category.getName());
            dto.setId(category.getId());

            dtos.add(dto);

        }

        return dtos;

    }


    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }


}
