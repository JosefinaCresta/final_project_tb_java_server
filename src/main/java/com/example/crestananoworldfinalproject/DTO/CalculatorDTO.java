package com.example.crestananoworldfinalproject.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CalculatorDTO {
    private String xc;
    private boolean lreal=false;
    @ElementCollection
    private List<Integer> kpts;
    private int ibrion;
    private double encut;
    private double ediffg;
    private int nsw;
    private int ispin;
    private int ncore;
    private String command;


}