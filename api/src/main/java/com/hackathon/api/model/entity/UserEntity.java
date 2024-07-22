package com.hackathon.api.model.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.api.model.Role;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role ;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Teams> teams;

}
