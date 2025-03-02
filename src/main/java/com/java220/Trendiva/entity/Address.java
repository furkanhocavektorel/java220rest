package com.java220.Trendiva.entity;

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
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
