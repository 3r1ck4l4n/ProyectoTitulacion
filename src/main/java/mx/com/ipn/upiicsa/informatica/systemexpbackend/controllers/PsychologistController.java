package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/psych")
public class PsychologistController {

    @Autowired
    PsychologistService psychologistService;


    @GetMapping("/{id}")
    public ResponseEntity<?> allUsers(@PathVariable("id") String id) {
        try {
            Integer idPsych = Integer.parseInt(id);
            return new ResponseEntity<>(psychologistService.getInfoProfile(idPsych), HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

    }


}
