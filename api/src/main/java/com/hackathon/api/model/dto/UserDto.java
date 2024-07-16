package com.hackathon.api.model.dto;

import com.hackathon.api.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Integer id;
    private String username;
    private String email;
    private String password;
    private Role role ;
}
