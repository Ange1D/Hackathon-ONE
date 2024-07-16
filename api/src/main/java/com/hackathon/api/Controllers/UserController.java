package com.hackathon.api.Controllers;

import com.hackathon.api.Service.impl.UserImpl;
import com.hackathon.api.model.Role;
import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.dto.VideogameDto;
import com.hackathon.api.model.entity.UserEntity;
import com.hackathon.api.model.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserImpl user;

    @RequestMapping("/hello")
    public String hello(){
        return "Hello Wordl";
    }

    @PostMapping("/createUser")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        UserEntity userEntity = null;
        try{
            userEntity = user.save(userDto);
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Save succes")
                            .object(UserDto.builder()
                                    .id(userEntity.getId())
                                    .email(userEntity.getEmail())
                                    .username(userEntity.getUsername())
                                    .password(userEntity.getPassword())
                                    .role(Role.valueOf(userEntity.getRole().name()))
                                    .build())
                            ,HttpStatus.CREATED
            );

        }catch (DataAccessException e){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUser(@PathVariable String id){

        UserEntity userEntity =  user.findById(Integer.parseInt(id));

        if (userEntity == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Not found")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(UserDto.builder()
                                .id(userEntity.getId())
                                .email(userEntity.getEmail())
                                .username(userEntity.getUsername()))
                        .build()
                , HttpStatus.OK);

    }

    @DeleteMapping("/deleteUSer/{id}")
    public String deleteUser(@PathVariable String id){
        user.delete(Integer.parseInt(id));
        return "se elimino el usuario con el id: " + id;
    }


}
