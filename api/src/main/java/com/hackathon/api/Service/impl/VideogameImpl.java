package com.hackathon.api.Service.impl;

import com.hackathon.api.Service.IVideogameService;
import com.hackathon.api.model.dao.VideogameDao;
import com.hackathon.api.model.dto.VideogameDto;
import com.hackathon.api.model.entity.Videogame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VideogameImpl implements IVideogameService {

    @Autowired
    private VideogameDao videogameDao;

    @Override
    public List<Videogame> listAll() {
        return (List<Videogame>) videogameDao.findAll();
    }

    @Transactional
    @Override
    public Videogame save(VideogameDto videogameDto) {
        Videogame videogame = Videogame.builder().
                id(videogameDto.getId()).
                name(videogameDto.getName()).
                status(videogameDto.getStatus()).
                build();
        return videogameDao.save(videogame);
    }

    @Transactional(readOnly = true)
    @Override
    public Videogame findById(Integer id) {
        return videogameDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Videogame videogame) {
        videogameDao.delete(videogame);
    }

    @Override
    public boolean existsById(Integer id) {
        return videogameDao.existsById(id);
    }

}
