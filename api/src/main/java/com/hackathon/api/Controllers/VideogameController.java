package com.hackathon.api.Controllers;

import com.hackathon.api.Service.IVideogameService;
import com.hackathon.api.model.dto.VideogameDto;
import com.hackathon.api.model.entity.Videogame;
import com.hackathon.api.model.payload.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VideogameController {

    @Autowired
    private IVideogameService videogameService;

    @GetMapping("/videogames")
    public ResponseEntity<?> showAll() {
        List<Videogame> getList = videogameService.listAll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Empty table")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }
        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }
    
    @PostMapping("/createVideogame")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> create(@RequestBody VideogameDto videogameDto) {
        Videogame videogameSave = null;
        try {
            videogameSave = videogameService.save(videogameDto);
            return new ResponseEntity<>(MessageResponse.builder()
                    .message("Save success")
                    .object(VideogameDto.builder().
                            id(videogameSave.getId()).
                            name(videogameSave.getName()).
                            status(videogameSave.getStatus()).
                            build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("/updateVideogame/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> update(@RequestBody VideogameDto videogameDto, @PathVariable Integer id) {
        Videogame videogameUpdate = null;
        try {
            if (videogameService.existsById(id)) {
                videogameDto.setId(id);
                videogameUpdate = videogameService.save(videogameDto);
                return new ResponseEntity<>(MessageResponse.builder()
                        .message("Save Success")
                        .object(VideogameDto.builder().
                                id(videogameUpdate.getId()).
                                name(videogameUpdate.getName()).
                                status(videogameUpdate.getStatus())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Not Found.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("/deleteVideogame/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Videogame videogameDelete = videogameService.findById(id);
            videogameService.delete(videogameDelete);
            return new ResponseEntity<>(videogameDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @GetMapping("/getOneVideogame/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Videogame videogame = videogameService.findById(id);

        if (videogame == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Not found")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("")
                        .object(VideogameDto.builder().
                                id(videogame.getId()).
                                name(videogame.getName()).
                                status(videogame.getStatus()).
                                build())
                        .build()
                , HttpStatus.OK);
    }
}
