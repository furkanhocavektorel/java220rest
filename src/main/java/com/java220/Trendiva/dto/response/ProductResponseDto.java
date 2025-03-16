package com.java220.Trendiva.dto.response;

import com.java220.Trendiva.entity.Category;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class ProductResponseDto {

    private Long id;

    private String brand;

    private String productName;

    private String description;

    private double price;

}
