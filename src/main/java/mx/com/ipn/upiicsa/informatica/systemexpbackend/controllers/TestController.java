package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;


import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Test;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/test")
public class TestController {

    private final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private TestService testService;

    @Secured({"ROLE_USER"})
    @GetMapping
    @RequestMapping("/{idTest}")
    public ResponseEntity<?> findTestByIdTest(@PathVariable String idTest){
        Test test = testService.findTestById(Integer.parseInt(idTest));
        if(test ==null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Test not found");
        return new ResponseEntity<>(test, HttpStatus.OK);
    }

    @RequestMapping("/all")
    @GetMapping
    public ResponseEntity<?> findAllTests(){
        List<Test> tests = testService.findAllTest();
        if (tests.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tests not found");
        return new ResponseEntity<>(tests,HttpStatus.OK);
    }

    @Secured({"ROLE_PSYCHOLOGIST"})
    @RequestMapping("/create")
    @PostMapping
    public ResponseEntity<?> createTest(@RequestBody Optional<Test> newTest){
        Test test = testService.createTest(newTest.get());
        if (test == null) throw new ResponseStatusException(HttpStatus.NOT_MODIFIED, "Tests not found");
        return new ResponseEntity<>(test, HttpStatus.CREATED);
    }
}
