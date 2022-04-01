package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dao.UserDAO;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.User;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UsersController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    UserService userService;

    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/all")
    public List<User> allUsers(){
        return userDAO.allUsers();
    }

    @PostMapping("/create")
    public boolean createUser(@RequestBody User user){
        return userService.createUser(user);
    }

}
