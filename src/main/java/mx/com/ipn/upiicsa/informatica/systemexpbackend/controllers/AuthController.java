package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import io.jsonwebtoken.Jwt;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.JwtUser;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Psychologist;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.security.JwtGenerator;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.PsychologistService;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final PsychologistService psychologistService;
    private final JwtGenerator jwtGenerator;

    public AuthController(JwtGenerator jwtGenerator, UserService userService,PsychologistService psychologistService){
        this.jwtGenerator = jwtGenerator;
        this.userService = userService;
        this.psychologistService = psychologistService;
    }

    @PostMapping("/user")
    public ResponseEntity<String> generateUserToken(@RequestBody Optional<User> user) {
        JwtUser jwtUser = userService.existUser(user.get());
        if (jwtUser == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Login data not send"));

        return new ResponseEntity<>(jwtGenerator.generate(jwtUser), HttpStatus.OK);
    }

    @PostMapping("/psychologist")
    public ResponseEntity<String> generatePsychologistToken(@RequestBody Optional<Psychologist> psychologist) {
        JwtUser jwtUser = psychologistService.existPsychologist(psychologist.get());
        if (jwtUser == null)
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Login data not send"));

        return new ResponseEntity<>(jwtGenerator.generate(jwtUser), HttpStatus.OK);
    }

}
