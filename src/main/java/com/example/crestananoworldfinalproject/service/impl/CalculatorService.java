package com.example.crestananoworldfinalproject.service.impl;

import com.example.crestananoworldfinalproject.model.Calculator;
import com.example.crestananoworldfinalproject.repository.CalculatorRepository;
import com.example.crestananoworldfinalproject.service.interfaces.CalculatorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CalculatorService implements CalculatorServiceInterface {
    @Autowired
    private CalculatorRepository calculatorRepository;

    public Calculator findById(Long id) {
        return calculatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Calculator not found"));
    }



    public void saveCalculator(Calculator calculator) {
        if (calculator.getId() != null) {
            Optional<Calculator> optionalCalculator = calculatorRepository.findById(calculator.getId());
            if (optionalCalculator.isPresent())
                throw new ResponseStatusException(
                        HttpStatus.UNPROCESSABLE_ENTITY, "Calculator with id " + calculator.getId() + " already exist");
        }
        Calculator calculator1 = calculatorRepository.save(calculator);
    }

    @Override
    public Calculator getCalculatorById(Long id) {
        Optional<Calculator> foundCalculator = calculatorRepository.findById(id);
        if(foundCalculator == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Calculator found with that ID");
        } else {
            return foundCalculator.get();
        }
    }


    public void deleteCalculator(Long id) {
        Calculator calculatorFromDB = calculatorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Calculator not found"));
        calculatorRepository.delete(calculatorFromDB);
    }

}
