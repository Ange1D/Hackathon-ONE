package com.hackathon.api.model.dto;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

import com.hackathon.api.model.entity.Teams;
import com.hackathon.api.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class MembersDto {
    private Long id;
    private String user;
    private Long team;
    private Long users;
    private Teams teams;

}
