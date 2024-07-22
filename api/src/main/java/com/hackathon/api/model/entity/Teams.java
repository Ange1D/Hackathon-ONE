package com.hackathon.api.model.entity;

// import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hackathon.api.model.Role;
import jakarta.persistence.*;
import lombok.*;




@Table(name = "teams")
@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long team_id;
    private String name;
    private Long team_number;
    private Integer video_game;
    private String description;
    private String create_at;
    private Long create_by;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
    private Role role;
   

}
