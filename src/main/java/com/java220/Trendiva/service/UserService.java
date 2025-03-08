package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import com.java220.Trendiva.entity.enums.Role;
import com.java220.Trendiva.repository.IAddressRepository;
import com.java220.Trendiva.repository.IUserRepository;
import org.springframework.stereotype.Service;

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


}
