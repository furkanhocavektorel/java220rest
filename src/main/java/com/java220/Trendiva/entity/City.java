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
@Table(name = "cities")
public class City extends BaseEntityInteger {


    @Column(name = "cityname")
    private String name;

    @Column(name = "plateno")
    private Integer plateCode;

}


