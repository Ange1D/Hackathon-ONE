package com.hackathon.api.Controllers;

import com.hackathon.api.Service.impl.UserImpl;
import com.hackathon.api.model.Role;
import com.hackathon.api.model.dto.UserDto;
import com.hackathon.api.model.entity.UserEntity;
import com.hackathon.api.model.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    UserImpl user;

    @PostMapping("user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        try{
            UserEntity userEntity = user.save(userDto);
            return new ResponseEntity<>(MessageResponse.builder()
                            .message("User saved successfully")
                            .object(UserDto.builder()
                                    .id(userEntity.getId())
                                    .email(userEntity.getEmail())
                                    .username(userEntity.getUsername())
                                    .password(userEntity.getPassword())
                                    .role(Role.valueOf(userEntity.getRole().name()))
                                    .build())
                            .build()
                            ,HttpStatus.CREATED
            );

        }catch (DataAccessException e){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Error saving user: " + e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED
            );
        }
    }

    @PutMapping("/user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable String id){
        try {
            if(user.existsById(Integer.parseInt(id))){
                userDto.setId(Integer.parseInt(id));
                user.update(userDto, Integer.parseInt(id));
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("User update successfully")
                        .object(UserDto.builder()
                                .id(userDto.getId())
                                .username(userDto.getUsername())
                                .email(userDto.getEmail())
                                .role(Role.valueOf(userDto.getRole().name()))
                                .build())
                        .build()
                , HttpStatus.CREATED);
            }else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Not Found.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        }catch (DataAccessException e){
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    @ResponseStatus(HttpStatus.OK)
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
                                .username(userEntity.getUsername())
                                .build())
                        .build()
                , HttpStatus.OK);

    }

    @DeleteMapping("user/{id}")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        try {
            user.delete(id);
            return new ResponseEntity<>("se elimino el usuario con id: " + id, HttpStatus.OK);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }


}
