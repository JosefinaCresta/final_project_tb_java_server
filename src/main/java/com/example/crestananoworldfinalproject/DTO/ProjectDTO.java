package com.example.crestananoworldfinalproject.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {
    private String title;
    private String description;
    private Long calculatorId;
    private String creator;
}