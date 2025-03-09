package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.UserResponseDto;
import com.java220.Trendiva.dto.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import com.java220.Trendiva.entity.enums.Role;
import com.java220.Trendiva.exception.custom.MyUserException;
import com.java220.Trendiva.repository.IAddressRepository;
import com.java220.Trendiva.repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository repository;

    public UserService(IUserRepository userRepository){
        this.repository=userRepository;
    }


    public void saveUser(UserSaveRequestDto userSaveRequestDto){

        Optional<User> user1= repository.findByEmail(userSaveRequestDto.getEmail());

        if (user1.isPresent()){
            throw new MyUserException("bu maile ait biri kayitli...");
        }

        user1=repository.findByUsername(userSaveRequestDto.getUsername());

        if (user1.isPresent()){
            throw new MyUserException("bu kullanici adina ait biri kayitli...");
        }


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
        Optional<User> user=  repository.findByUsername(username);

        if (user.isEmpty()){
            throw new MyUserException("kullanici adına ait kayit bulunamadi...");
        }



        UserResponseDto dto = new UserResponseDto();

        dto.setEmail(user.get().getEmail());
        dto.setId(user.get().getId());
        dto.setName(user.get().getName());
        dto.setUsername(user.get().getUsername());

        return dto;
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public UserResponseDto updateUser(Long id, UserSaveRequestDto userSaveRequestDto) {

        Optional<User> existingUser = repository.findById(id);

        if (existingUser.isEmpty()){
           throw new MyUserException(id+" ye sahip kullanici bulunamadi....");
        }

        existingUser.get().setEmail(userSaveRequestDto.getEmail());
        existingUser.get().setUsername(userSaveRequestDto.getUsername());
        existingUser.get().setPassword(userSaveRequestDto.getPassword());
        existingUser.get().setRole(Role.valueOf(userSaveRequestDto.getRole()));

        User updatedUser = repository.save(existingUser.get());

        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(updatedUser.getId());
        responseDto.setUsername(updatedUser.getUsername());
        responseDto.setEmail(updatedUser.getEmail());
        responseDto.setName(updatedUser.getName());

        return responseDto;
    }

}
