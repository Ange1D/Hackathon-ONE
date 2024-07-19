package com.hackathon.api.Service;

import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.entity.UserEntity;
import com.hackathon.api.model.entity.Videogame;

import java.util.Optional;


public interface IUserService {


    UserEntity save(UserDto userDto);

    UserEntity findById(Integer id);

    void update(UserDto userDto, Integer id);

    void delete(Integer id);

    boolean existsById(Integer id);



}
