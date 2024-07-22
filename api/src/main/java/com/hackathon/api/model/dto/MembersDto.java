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
    private Long members_id;
    private String user;
    private Integer team_number;
    private UserEntity users;
    private Teams teams;

}
