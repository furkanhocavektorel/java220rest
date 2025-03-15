package com.java220.Trendiva.controller;

import com.java220.Trendiva.dto.UserResponseDto;
import com.java220.Trendiva.dto.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import com.java220.Trendiva.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("get-all")
    public List<UserResponseDto> getAllUser(){
       return userService.getAllUser();
    }

    @GetMapping("getbyusername")
    public UserResponseDto getByUsername(String username){
        return userService.getUserByUsername(username);
    }

    @DeleteMapping("delete")
    public void deleteAll(Long id){
        userService.deleteUser(id);
    }

    @PutMapping("update/{id}")
    public UserResponseDto updateUser(@PathVariable Long id, @RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.updateUser(id, userSaveRequestDto);
    }

    @DeleteMapping("soft-delete")
    public void softDeleteByUserId(long id){
        userService.softDelete(id);
    }



    @GetMapping("test2/{sayi2}")
    public int test2(@PathVariable int sayi2){
        int a= 56-sayi2;
        return a;
    }


    @GetMapping("test")
    public int test(@RequestParam int sayi,int sayi2){
        int a= sayi*56-sayi2;
        return a;
    }



}
