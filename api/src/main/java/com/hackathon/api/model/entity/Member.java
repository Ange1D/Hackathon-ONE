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
    private Long members_id;
    private String user;
    private Integer team_number;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity users;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Teams teams;
}
