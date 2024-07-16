package com.hackathon.api.model.dao;

import com.hackathon.api.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserDao extends CrudRepository<UserEntity, Integer> {


    Optional<UserEntity> findByUsername(String username);

}
