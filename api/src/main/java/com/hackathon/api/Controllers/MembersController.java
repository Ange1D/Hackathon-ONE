package com.hackathon.api.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.hackathon.api.Service.impl.MembersImp;
import com.hackathon.api.model.dto.MembersDto;
import com.hackathon.api.model.entity.Member;
import com.hackathon.api.model.payload.MessageResponse;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;





@RestController
@RequestMapping("/member")

public class MembersController {
    @Autowired
    MembersImp memberI;

    @PostMapping("/createmember")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> creatingmember(@RequestBody MembersDto membersDto) {
        //TODO: process POST request
        try {
            Member member = memberI.save(membersDto);
            return new ResponseEntity<>(MessageResponse.builder()
                .message("Member created successfully")
                .object(membersDto.builder()
                .members_id(member.getMembers_id())
                .user(membersDto.getUser())
                .team_number(membersDto.getTeam_number())
                .build())
            .build()
            , HttpStatus.CREATED);

        } catch (Exception e) {
            // TODO: handle exception
            return new ResponseEntity<>(
                MessageResponse.builder()
                    .message("Member creation failed"+ e.getMessage())
                    .object(null)
                    .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }
    
    @PutMapping("memberUpdate/{name}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> updateMember(@RequestBody MembersDto membersDto, @PathVariable String username) {
        //TODO: process PUT request
        
        try {
            if(memberI.existsByname(username)){
                membersDto.setUser(username);
                memberI.actualizarMembers(membersDto, username);
                return new ResponseEntity<>(MessageResponse.builder()
                    .message("Member update successfully")
                    .object(membersDto)
                    .build(), HttpStatus.CREATED);
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Member not found")
                    .object(null)
                    .build(),
                    HttpStatus.NOT_FOUND);
                
            }
        }

         catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }
    @DeleteMapping("/deletemember/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deletememeber(@PathVariable Long id){
        try {
            if(memberI.existsById(id)){
                Member memberborrar = memberI.findMembers(id);
                memberI.delete(memberborrar);
                return new ResponseEntity<>(MessageResponse.builder()
                    .message("Member deleted successfully")
                    .object(null)
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
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/listofmemebers/{id}")
    public ResponseEntity<?> listofmembersbyId(@RequestParam Long id) {
        try {
            Member member = memberI.findMembers(id);
            if(member != null){
                return new ResponseEntity<>(MessageResponse.builder()
                    .message("Member found successfully")
                    .object(member)
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
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
       
    }

    @GetMapping("listarallmembers")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> ListallMembers() {
        try {
            List<Member> listmembers = memberI.listAll();
            if(listmembers == null){
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("No members found")
                    .object(null)
                    .build()
                , HttpStatus.NOT_FOUND);
            }
            else{
                return new ResponseEntity<>(
                    MessageResponse.builder()
                    .message("Members found successfully")
                    .object(listmembers)
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
