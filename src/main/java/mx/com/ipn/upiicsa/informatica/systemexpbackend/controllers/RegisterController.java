package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;


import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserRegisterDTO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/register")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody Optional<UserRegisterDTO> user) {
        return new ResponseEntity<>(userService.createUser(user.get()), HttpStatus.CREATED);
    }

    @PostMapping("/psychologist")
    public ResponseEntity<?> createPsychologist(@RequestBody Optional<UserRegisterDTO> psychologist) {
        return new ResponseEntity<>(psychologistService.createPsychologist(psychologist.get()), HttpStatus.CREATED);
    }
}