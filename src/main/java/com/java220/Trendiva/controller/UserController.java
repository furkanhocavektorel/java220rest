package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.UserSaveRequestDto;
import com.java220.Trendiva.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:8097/kullanici
@RestController
@RequestMapping("kullanici")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // http://localhost:8097/kullanici/save
    @PostMapping("save")
    public void saveUser(@RequestBody UserSaveRequestDto userSaveRequestDto){

        userService.saveUser(userSaveRequestDto);

    }


}
