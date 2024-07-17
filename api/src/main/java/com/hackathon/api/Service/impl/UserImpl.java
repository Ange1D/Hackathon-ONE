package com.hackathon.api.Service.impl;

import com.hackathon.api.Service.IUserService;
import com.hackathon.api.model.Role;
import com.hackathon.api.model.dao.UserDao;
import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(UserDto userDto) {
        UserEntity userEntity = UserEntity.builder()
                .email(userDto.getEmail())
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .role(Role.valueOf(userDto.getRole().name()))
                .build();
        return userDao.save(userEntity);
    }

    @Override
    public UserEntity findById(Integer id) {

        return userDao.findById(id).orElse(null);
    }

    @Override
    public void delete(Integer id) {
        userDao.deleteById(id);

    }

    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }

}
