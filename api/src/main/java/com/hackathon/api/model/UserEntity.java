package com.hackathon.api.model;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "users")
@Entity(name = "User")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode(of = "id")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role = Role.USER;

}
