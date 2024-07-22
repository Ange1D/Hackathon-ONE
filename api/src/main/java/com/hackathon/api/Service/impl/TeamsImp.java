package com.hackathon.api.Service.impl;

import java.util.List;
import java.util.Optional;

import org.glassfish.jaxb.core.annotation.OverrideAnnotationOf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.hackathon.api.Service.ITeams;
import com.hackathon.api.model.dao.TeamsDao;
import com.hackathon.api.model.dto.TeamsDto;
import com.hackathon.api.model.entity.Teams;



public class TeamsImp implements ITeams{
    @Autowired
    private TeamsDao teamsDao;
    

    @Override
    public
    List<Teams> listAll(){
        return (List<Teams>) teamsDao.findAll();
    }

  
    @Transactional
    @Override
    public void delete(Teams teams){
        teamsDao.delete(teams);
    }

    @Override
    public boolean existsById(Long id){
        return teamsDao.existsById(id);
    }

    @Transactional(readOnly =  true)
    @Override
    public Teams findTeams(Long id){
        return teamsDao.findById(id).orElse(null);
    
    }

    @Transactional
	@Override
	public Teams save(TeamsDto teamsDto) {
		Teams teams = Teams.builder()
                      .team_id(teamsDto.getId())
                      .name(teamsDto.getName())
                      .team_number(teamsDto.getTeam_number())
                      .video_game(teamsDto.getVideo_game())
                      .description(teamsDto.getDescription())
                      .create_at(teamsDto.getCreate_at())
                      .create_by(teamsDto.getCreate_by())
                      .build();
        return teamsDao.save(teams);
    }   

    @Transactional
	@Override
    public Teams actualizarTeams(TeamsDto teamsDto, String name ){
        Teams teams = teamsDao.findByTeamName(name);
        teams.setName(teamsDto.getName());
        teams.setTeam_number(teamsDto.getTeam_number());
        teams.setVideo_game(teamsDto.getVideo_game());
        teams.setDescription(teamsDto.getDescription());
        teams.setCreate_at(teamsDto.getCreate_at());
        teams.setCreate_by(teamsDto.getCreate_by());
        return teamsDao.save(teams);
        

    }

    
    
}
