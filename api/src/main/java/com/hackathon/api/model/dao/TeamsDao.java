package com.hackathon.api.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.hackathon.api.model.entity.Teams;

public interface TeamsDao extends CrudRepository<Teams, Long>{
    
    Teams findByTeamName(String teamName);

    
}
