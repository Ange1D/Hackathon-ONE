package com.hackathon.api.model.dao;

import com.hackathon.api.model.entity.Videogame;
import org.springframework.data.repository.CrudRepository;

public interface VideogameDao extends CrudRepository<Videogame, Integer> {
}
