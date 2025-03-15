package com.java220.Trendiva.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserSaveRequestDto {

    private String username;
    private String email;
    private String password;
    private String role;

}
