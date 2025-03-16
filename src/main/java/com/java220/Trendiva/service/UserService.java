package com.java220.Trendiva.service;

import com.java220.Trendiva.dto.request.LoginRequestDto;
import com.java220.Trendiva.dto.response.UserResponseDto;
import com.java220.Trendiva.dto.request.UserSaveRequestDto;
import com.java220.Trendiva.entity.User;
import com.java220.Trendiva.entity.enums.Role;
import com.java220.Trendiva.exception.custom.MyUserException;
import com.java220.Trendiva.exception.custom.TokenException;
import com.java220.Trendiva.mapper.UserMapper;
import com.java220.Trendiva.repository.IUserRepository;
import com.java220.Trendiva.util.JwtTokenManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final IUserRepository repository;
    private final JwtTokenManager jwtTokenManager;

    public UserService(IUserRepository userRepository, JwtTokenManager jwtTokenManager){
        this.repository=userRepository;
        this.jwtTokenManager = jwtTokenManager;
    }


    public void saveUser(UserSaveRequestDto userSaveRequestDto){

        Optional<User> user1= repository.findByEmail(userSaveRequestDto.getEmail());

        if (user1.isPresent()){
            throw new MyUserException("bu maile ait biri kayitli...",4001);
        }

        user1=repository.findByUsername(userSaveRequestDto.getUsername());

        if (user1.isPresent()){
            throw new MyUserException("bu kullanici adina ait biri kayitli...",4002);
        }


       User user= new User();
       user.setEmail(userSaveRequestDto.getEmail());
       user.setUsername(userSaveRequestDto.getUsername());
       user.setPassword(userSaveRequestDto.getPassword());
       user.setRole(Role.valueOf(userSaveRequestDto.getRole()));
       repository.save(user);
    }


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
            throw new MyUserException("kullanici adına ait kayit bulunamadi...",4003);
        }


        // User -> UserResponseDto

        UserResponseDto dto = UserMapper.INSTANCE.toUserResponseDto(user.get());

        return dto;
    }


    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

    public UserResponseDto updateUser(Long id, UserSaveRequestDto userSaveRequestDto) {

        User existingUser = repository.findById(id).orElseThrow(()->  new MyUserException("kullanici yok",4004));

        existingUser=UserMapper.INSTANCE.toUser(userSaveRequestDto);

        User updatedUser = repository.save(existingUser);

        // user -> UserResponseDto

        return UserMapper.INSTANCE.toUserResponseDto(updatedUser);
    }


    public void softDelete(long id) {
        Optional<User> user =repository.findById(id);

        if (user.isEmpty()){
            throw new MyUserException("kullanici bulunamadi",4005);
        }
        user.get().setDeleted(true);

        repository.save(user.get());
    }


    public String login(LoginRequestDto dto) {
        User user= repository.findByUsername(dto.getUsername())
                .orElseThrow(()-> new MyUserException("kullanici bulunamadi",4006));

        if (!user.getPassword().equals(dto.getPassword())){
            throw new MyUserException("şifre eşleşmiyor...",4007);
        }

        String token=jwtTokenManager.createToken(user.getId()).orElseThrow(()-> new TokenException("bilinmeyen hata",2002));

        return token;
    }

}
