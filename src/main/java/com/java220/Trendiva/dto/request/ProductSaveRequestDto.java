package com.java220.Trendiva.dto.request;

import com.java220.Trendiva.entity.Category;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductSaveRequestDto {


    private String brand;

    private String name;

    private double price;

    private Long categoryId;


}
