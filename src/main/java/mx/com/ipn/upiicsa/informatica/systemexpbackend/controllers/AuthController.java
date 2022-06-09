package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.LoginUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserSession;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.security.JwtGenerator;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthController {

    Logger logger = LoggerFactory.getLogger(AuthController.class);
    private final UserService userService;
    private final PsychologistService psychologistService;
    private final JwtGenerator jwtGenerator;

    public AuthController(JwtGenerator jwtGenerator, UserService userService,PsychologistService psychologistService){
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
        this.psychologistService = psychologistService;
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> generateUserToken(@RequestBody Optional<LoginUser> user) {
        JwtUser jwtUser = userService.existUser(user.get());
        if (jwtUser == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Login data not send"));
        UserSession userSession = userService.getUser(jwtUser.getId());
        userSession.setToken(jwtGenerator.generate(jwtUser));
        return new ResponseEntity<>(userSession, HttpStatus.OK);
    }

    @PostMapping(value = "/psychologist")
    public ResponseEntity<?> generatePsychologistToken(@RequestBody Optional<LoginUser> user) {
        Psychologist psychologist = new Psychologist(user.get().getEmail(), user.get().getPassword());
        logger.info(psychologist.toString());
        JwtUser jwtUser = psychologistService.existPsychologist(psychologist);
        if (jwtUser == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Login data not send"));
        UserSession userSession = psychologistService.getPsychologist(jwtUser.getId());
        userSession.setToken(jwtGenerator.generate(jwtUser));
        return new ResponseEntity<>(userSession, HttpStatus.OK);
    }

}
