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
    private Long id;
    private String name;
    private Integer video_game;
    private String description;
    private String create_at;
    @ManyToOne
    @JoinColumn(name = "create_by")
    private UserEntity create_by;


}
