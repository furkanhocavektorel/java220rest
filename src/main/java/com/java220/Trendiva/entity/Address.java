package com.java220.Trendiva.entity;

import com.java220.Trendiva.entity.base.BaseEntityLong;
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
public class Address extends BaseEntityLong {

    @ManyToOne
    private City city;

    @ManyToOne
    private Neighborhood neighborhood;

    private String address;
    private String apartment;
    private String floor;

    @ManyToOne
    private User user;
}
