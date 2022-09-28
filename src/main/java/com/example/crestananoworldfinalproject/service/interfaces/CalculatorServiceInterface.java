package com.example.crestananoworldfinalproject.service.interfaces;

import com.example.crestananoworldfinalproject.model.Calculator;

public interface CalculatorServiceInterface {
    Calculator getCalculatorById(Long id);
   /* void setCalculator(Long calculatorId);*/

    void saveCalculator(Calculator calculator);

    void deleteCalculator(Long id);
}
