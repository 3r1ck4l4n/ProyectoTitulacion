package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserService userService;
    @Secured({"ROLE_USE"})
    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }


    @Secured({"ROLE_PSYCHOLOGIST"})
    @GetMapping("/all")
    public ResponseEntity<List<User>> allUsers(){
        return new ResponseEntity<List<User>>(userDAO.findAll(), HttpStatus.OK);
    }



}
