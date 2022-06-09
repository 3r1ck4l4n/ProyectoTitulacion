package mx.com.ipn.upiicsa.informatica.systemexpbackend.controllers;

import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ResultDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.dto.ResultResponseDto;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.models.Result;
import mx.com.ipn.upiicsa.informatica.systemexpbackend.services.ResultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api/result")
public class ResultController {

    private final Logger logger = LoggerFactory.getLogger(ResultController.class);

    @Autowired
    private ResultService resultService;



    @Secured({"ROLE_USER"})
    @PostMapping
    @RequestMapping("/save")
    public ResponseEntity<?> saveResult(@RequestBody ResultDto resultDto){

        logger.info(resultDto.toString());
        BigDecimal result = resultService.calculateCF(resultDto);
        logger.info("CertainFactor -> "+result.toString());

        String message = result.floatValue() <= 0.4?
                "El factor de certeza es bajo. No existe riesgo latente!":
                "El factor de certeza de padecer ansiedad o depresión es elevado.   " +
                        "En breve el psicólogo te contactará por email";


        Result result1 = new Result(resultDto.getIdUser(), resultDto.getIdTest(), result, message);
        resultService.createResult(result1);
        return  new ResponseEntity<>(new ResultResponseDto(message, result),HttpStatus.CREATED);
    }

    @Secured({"ROLE_PSYCHOLOGIST"})
    @GetMapping("/statistics")
    public ResponseEntity<?> resultStatisticsWithCertainFactor(){

        return new ResponseEntity<>(resultService.getStatisticsResult(), HttpStatus.OK);
    }


}
