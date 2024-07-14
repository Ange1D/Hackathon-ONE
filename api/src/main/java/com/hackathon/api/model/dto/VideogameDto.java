package com.hackathon.api.model.dto;

import lombok.*;

import java.io.Serializable;

@Data
@ToString
@Builder
public class VideogameDto implements Serializable {

    private Integer id;
    private String name;
    private String status;

}
