package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.UserDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/user")
public class UsersController {

    private final Logger logger = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    UserService userService;

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }



    @Secured({"ROLE_PSYCHOLOGIST"})
    @GetMapping("/all")
    public ResponseEntity<?> allUsers() {

        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @Secured({"ROLE_PSYCHOLOGIST"})
    @GetMapping("/historical")
    public ResponseEntity<?> historicalRegisterUsers() throws ParseException {
        return new ResponseEntity<>(userService.historicalRegisterUsers(), HttpStatus.OK);
    }

    @Secured({"ROLE_PSYCHOLOGIST"})
    @GetMapping("/{idUser}")
    public  ResponseEntity<?> findUserById(@PathVariable("idUser") Integer idUser){
        UserDto userDto = userService.findUserById(idUser);
        logger.info(userDto.toString());
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

}
