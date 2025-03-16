package com.java220.Trendiva.entity;

import com.java220.Trendiva.entity.base.BaseEntityLong;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntityLong {

    private String brand;

    private String name;

    private String description;

    private int stock;

    private double price;

    private String url;

    @ManyToOne
    private Category category;

}
