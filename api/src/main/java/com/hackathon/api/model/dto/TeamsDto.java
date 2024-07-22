package com.hackathon.api.model.dto;

import com.hackathon.api.model.Role;
import com.hackathon.api.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class TeamsDto {
    
    private Long id;
    private String name;
    private Long team_number;
    private Integer video_game;
    private String description;
    private String create_at;
    private Long create_by;
    private UserEntity user;
    private Role role;

}
