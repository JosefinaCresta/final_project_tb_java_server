package com.example.crestananoworldfinalproject.controller;

import com.example.crestananoworldfinalproject.model.Calculator;
import com.example.crestananoworldfinalproject.repository.CalculatorRepository;
import com.example.crestananoworldfinalproject.repository.ProjectRepository;
import com.example.crestananoworldfinalproject.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class CalculatorController {
    @Autowired
    private CalculatorRepository calculatorRepository;

    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/calculators")
    @ResponseStatus(HttpStatus.OK)
    public List<Calculator> getCalculators() {
        return calculatorRepository.findAll();
    }

    @GetMapping("/calculators/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Calculator getCalculatorById(@PathVariable(name = "id") Long calculatorId) {
        return calculatorService.findById(calculatorId);
    }

    @GetMapping("/calculators/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Integer getCountOfCalculatorById(@PathVariable(name = "id") Long calculatorId) {
        Integer count = projectRepository.countByCalculatorId(calculatorId);
        return projectRepository.countByCalculatorId(calculatorId);
    }


    @PostMapping("/calculators")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCalculator(@RequestBody Calculator calculator){
        calculatorService.saveCalculator(calculator);
    }


    @DeleteMapping("/calculators/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCalculator(@PathVariable Long id){
        calculatorService.deleteCalculator(id);
    }
}


