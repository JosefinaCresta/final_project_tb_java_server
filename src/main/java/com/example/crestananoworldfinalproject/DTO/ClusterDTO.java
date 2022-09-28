package com.example.crestananoworldfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClusterDTO {
    private String formula;
    private int natoms;
    private double energy;
    @ElementCollection
    private List<Double> forces;
    private double mag;
    private Long projectId;
}
