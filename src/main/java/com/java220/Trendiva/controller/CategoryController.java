package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.response.CategoryResponseDto;
import com.java220.Trendiva.dto.request.CategorySaveRequestDto;
import com.java220.Trendiva.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/category")
@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("save")
    public void save(CategorySaveRequestDto dto){
        categoryService.save(dto);
    }

    @GetMapping("get-all")
    public List<CategoryResponseDto> getAll(){
        return categoryService.findAll();
    }


}
