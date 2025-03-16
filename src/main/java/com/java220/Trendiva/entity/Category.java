package com.java220.Trendiva.entity;

import com.java220.Trendiva.entity.base.BaseEntityLong;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Category extends BaseEntityLong {

    private String name;

    private String description;
}
