package com.hackathon.api.Service;

import com.hackathon.api.model.dto.VideogameDto;
import com.hackathon.api.model.entity.Videogame;

import java.util.List;

public interface IVideogameService {

    List<Videogame> listAll();

    Videogame save(VideogameDto videogame);

    Videogame findById(Integer id);

    void delete(Videogame videogame);

    boolean existsById(Integer id);
}
