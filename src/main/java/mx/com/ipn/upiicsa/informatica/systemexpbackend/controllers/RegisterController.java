package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;


import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/register")
public class RegisterController {

    Logger logger = LoggerFactory.getLogger(RegisterController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PsychologistService psychologistService;

    @PostMapping("/user")
    public ResponseEntity<User> createUser(@RequestBody Optional<User> user) {
        return new ResponseEntity<User>(userService.createUser(user.get()), HttpStatus.CREATED);
    }

    @PostMapping("/psychologist")
    public ResponseEntity<Psychologist> createPsychologist(@RequestBody Optional<Psychologist> psychologist) {
        return new ResponseEntity<Psychologist>(psychologistService.createPsychologist(psychologist.get()), HttpStatus.CREATED);
    }
}