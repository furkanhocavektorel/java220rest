package com.java220.Trendiva.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {

    private String username;
    private String name;
    private String email;
    private Boolean isDeleted;
    private Long id;
}
