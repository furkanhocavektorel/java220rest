package com.java220.Trendiva.dto.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StoreSaveRequestDto {

    private String vkn;

    private String name;

    private String email;

}
