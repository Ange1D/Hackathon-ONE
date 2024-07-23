package com.hackathon.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.hackathon.api.Service.impl.TeamsImp;
import com.hackathon.api.model.dto.TeamsDto;
import com.hackathon.api.model.entity.Teams;
import com.hackathon.api.model.payload.MessageResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api/v1")


public class TeamsController {
    
    @Autowired
    TeamsImp teamI;

    @PostMapping("team")
    public ResponseEntity<?> creatingteams(@RequestBody TeamsDto teamsDto) {
        //TODO: process POST request
        try {
            Teams teams = teamI.save(teamsDto);
            return new ResponseEntity<>(MessageResponse.builder()
                .message("Teams created succcessfully")
                .object(teamsDto.builder()
                .id(teams.getId())
                .name(teamsDto.getName())
                .video_game(teamsDto.getVideo_game())
                .description(teamsDto.getDescription())
                .create_at(teamsDto.getCreate_at())
                .create_by(teamsDto.getCreate_by())
                .build())
            .build()
            , HttpStatus.CREATED);
        } catch (Exception e) {
            // TODO: handle exception

                return new ResponseEntity<>(
                MessageResponse.builder()
                .message("Teams creation failed" + e.getMessage())
                .object(null)
                .build(), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
        
    }

    @PutMapping("team/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> putMethodName(@RequestBody TeamsDto teamsDto, @PathVariable Long id) {
        //TODO: process PUT request
        try {
            if(teamI.existsById(id)){

                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Teams update succcessfully")
                    .object(null)
                    .build(), HttpStatus.OK
                );
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Member not found")
                    .object(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
                
            }
            
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Teams update succcessfully")
                    .object(null)
                    .build(), HttpStatus.OK
                );
        }
        
    }

    @DeleteMapping("team/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteTeams(@PathVariable Long id){

        try {
            if(teamI.existsById(id)){
                Teams teamdelete = teamI.findTeams(id);
                teamI.delete(teamdelete);
                return new ResponseEntity<>(teamdelete, HttpStatus.NO_CONTENT);
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Teams not found")
                    .object(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                    MessageResponse.builder()
                        .message(e.getMessage())
                        .object(null)
                        .build(),
                    HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("team/{id}")
    public ResponseEntity<?> listofteamsbyId(@RequestParam Long id){
        try {
            Teams teams = teamI.findTeams(id);
            if (teams != null){
                return new ResponseEntity<>(MessageResponse.builder()
                    .message("Member found successfully")
                    .object(teams)
                    .build(), HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Member not found")
                    .object(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @GetMapping("teams")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> listofallTeams(){
        try {
            List<Teams> teamslist = teamI.listAll();
            if(teamslist.isEmpty()){
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("No teams found")
                    .object(null)
                    .build()
                , HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Teams found successfully")
                    .object(teamslist)
                    .build()
                , HttpStatus.OK);
            }
        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                MessageResponse.builder()
                .message(e.getMessage())
                .object(null)
                .build()
            , HttpStatus.METHOD_NOT_ALLOWED);

        }
    }
    
}
