package com.hackathon.api.model.entity;

import com.hackathon.api.model.Role;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "members")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;
    @ManyToOne
    @JoinColumn(name = "team")
    private Teams team;
}
