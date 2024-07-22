package com.hackathon.api.Service;

import java.util.List;
import com.hackathon.api.model.dto.TeamsDto;
import com.hackathon.api.model.entity.Teams;

public interface ITeams {

    List<Teams> listAll();

    Teams save(TeamsDto teamsDto);
    
    void delete(Teams teams);

    boolean existsById(Long id);

    Teams findTeams(Long id);

    Teams actualizarTeams(TeamsDto teamsDto, String name );

    

}
