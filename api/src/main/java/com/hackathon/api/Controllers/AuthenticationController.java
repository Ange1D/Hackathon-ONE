package com.hackathon.api.Controllers;

import com.hackathon.api.Security.JWTToken;
import com.hackathon.api.Security.jwt.JwtUtils;
import com.hackathon.api.model.dto.LoginDto;
import com.hackathon.api.model.dto.VideogameDto;
import com.hackathon.api.model.entity.UserEntity;
import com.hackathon.api.model.entity.Videogame;
import com.hackathon.api.model.payload.MessageResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils tokenService;

    @PostMapping
    public ResponseEntity Login(@RequestBody @Valid LoginDto loginDto){

        Authentication AuthTtoken = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        Authentication userVerified = authenticationManager.authenticate(AuthTtoken);
        String JWTToken = tokenService.generateAccesToken((loginDto.username()));
        return ResponseEntity.ok(new JWTToken(JWTToken));
    }
}
