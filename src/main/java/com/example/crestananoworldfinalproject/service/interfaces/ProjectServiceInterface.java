package com.example.crestananoworldfinalproject.service.interfaces;


import com.example.crestananoworldfinalproject.DTO.ProjectDTO;
import com.example.crestananoworldfinalproject.model.Project;

public interface ProjectServiceInterface {
    Project findById(Long id);
    void saveProject(ProjectDTO project);
    void update(Long id, Project project);
    void deleteProject(Long id);
}
