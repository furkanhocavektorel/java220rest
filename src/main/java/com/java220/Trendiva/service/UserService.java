package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.UserResponseDto;
import com.java220.Trendiva.dto.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import com.java220.Trendiva.entity.enums.Role;
import com.java220.Trendiva.repository.IAddressRepository;
import com.java220.Trendiva.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final IUserRepository repository;

    public UserService(IUserRepository userRepository){
        this.repository=userRepository;
    }


    public void saveUser(UserSaveRequestDto userSaveRequestDto){

       User user= new User();
       user.setEmail(userSaveRequestDto.getEmail());
       user.setUsername(userSaveRequestDto.getUsername());
       user.setPassword(userSaveRequestDto.getPassword());
       user.setRole(Role.valueOf(userSaveRequestDto.getRole()));
       repository.save(user);
    }

    // kullanıcıların username ve mail adresleri listelenecek.


    public List<UserResponseDto> getAllUser(){
        List<User> users= repository.findAll();

        List<UserResponseDto> dtos= new ArrayList<>();

        for (User u : users){

            UserResponseDto userResponseDto= new UserResponseDto();
            userResponseDto.setUsername(u.getUsername());
            userResponseDto.setId(u.getId());
            userResponseDto.setName(u.getName());
            userResponseDto.setEmail(u.getEmail());

            dtos.add(userResponseDto);
        }

        return dtos;
    }


    public UserResponseDto getUserByUsername(String username) {
        User user=  repository.findByUsername(username);

        UserResponseDto dto = new UserResponseDto();

        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setUsername(user.getUsername());

        return dto;
    }


    public void deleteUser(Long id) {

        repository.deleteById(id);


    }



}
