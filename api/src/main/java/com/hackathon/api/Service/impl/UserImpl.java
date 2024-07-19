package com.hackathon.api.Service.impl;

import com.hackathon.api.Service.IUserService;
import com.hackathon.api.model.Role;
import com.hackathon.api.model.dao.UserDao;
import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UserImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
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

    @Transactional(readOnly = true)
    @Override
    public UserEntity findById(Integer id) {

        return userDao.findById(id).orElse(null);
    }

    @Override
    public void update(UserDto userDto, Integer id) {
        Optional<UserEntity> optionalUser = userDao.findById(id);

        if(optionalUser.isPresent() ){
            UserEntity user = optionalUser.get();
            user.setEmail(userDto.getEmail());
            user.setUsername(userDto.getUsername());
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            user.setRole( Role.valueOf(userDto.getRole().name()));

            userDao.save(user);
        }else {
            System.out.println("el usuario con id " + id + "no existe");
        }
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        userDao.deleteById(id);

    }

    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }

}
