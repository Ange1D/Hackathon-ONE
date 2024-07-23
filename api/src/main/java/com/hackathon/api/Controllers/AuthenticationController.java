package com.hackathon.api.Controllers;

import com.hackathon.api.Security.JWTToken;
import com.hackathon.api.Security.jwt.JwtUtils;
import com.hackathon.api.model.dto.LoginDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.core.Authentication;

// indica que esta clase es un controlador REST y se encargará de manejar las solicitudes HTTP
@RestController
// Ruta base para el controlador
@RequestMapping("/api/v1")
public class AuthenticationController {

    // Inyección de dependencias
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils tokenService;


    // Manejo de las solicitudes HTTP POST en la ruta "/api/v1/login"
    @PostMapping("login")
    //El método toma un objeto LoginDto como parámetro de solicitud y devuelve una respuesta ResponseEntity
    public ResponseEntity Login(@RequestBody @Valid LoginDto loginDto){

        // Crea un objeto UsernamePasswordAuthenticationToken con las credenciales proporcionadas
        Authentication AuthTtoken = new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password());
        // Autentica al usuario utilizando el AuthenticationManager
        Authentication userVerified = authenticationManager.authenticate(AuthTtoken);
        // Genera un token JWT utilizando el JwtUtils
        String JWTToken = tokenService.generateAccesToken((loginDto.username()));
        // Devuelve una respuesta con el token JWT
        return ResponseEntity.ok(new JWTToken(JWTToken));
    }
}
