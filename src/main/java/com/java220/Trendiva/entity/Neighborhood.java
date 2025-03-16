package com.java220.Trendiva.entity;

import com.java220.Trendiva.entity.base.BaseEntityInteger;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "counties")
public class Neighborhood extends BaseEntityInteger {


    @Column(name = "countyname")
    private String name;

    @ManyToOne
    private City city;
}
