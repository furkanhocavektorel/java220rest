package com.java220.Trendiva.entity;

import com.java220.Trendiva.entity.base.BaseEntityLong;
import com.java220.Trendiva.entity.enums.StoreStatus;
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
public class Store extends BaseEntityLong {

    private String vkn;

    private String name;

    @OneToOne
    private Address address;

    private String phoneNumber;

    private String email;

    @Enumerated(EnumType.STRING)
    private StoreStatus storeStatus = StoreStatus.OPEN;


}
