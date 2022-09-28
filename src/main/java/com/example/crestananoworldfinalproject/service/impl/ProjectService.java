package com.example.crestananoworldfinalproject.service.impl;


import com.example.crestananoworldfinalproject.DTO.ProjectDTO;
import com.example.crestananoworldfinalproject.model.Calculator;
import com.example.crestananoworldfinalproject.model.Project;
import com.example.crestananoworldfinalproject.repository.CalculatorRepository;
import com.example.crestananoworldfinalproject.repository.ProjectRepository;
import com.example.crestananoworldfinalproject.service.interfaces.CalculatorServiceInterface;
import com.example.crestananoworldfinalproject.service.interfaces.ProjectServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProjectService implements ProjectServiceInterface {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private CalculatorRepository calculatorRepository;

    @Autowired
    private CalculatorServiceInterface calculatorService;

    public Project findById(Long id) {
        return projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project not found"));
    }

    public void saveProject(ProjectDTO project) {
        Calculator calculatorFromId = calculatorService.getCalculatorById(project.getCalculatorId());
        try {
            projectRepository.save(new Project(
                    project.getTitle(),
                    project.getDescription(),project.getCreator(),
                    calculatorFromId
            ));
        } catch (Exception e){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Malformed Project");
        }
    }

    public void update(Long id, Project project) {
        Optional<Project> foundProject = projectRepository.findById(id);
        if(foundProject == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No Project found with that ID");
        } else {
            if(!project.getTitle().isEmpty()){
                foundProject.get().setTitle(project.getTitle());
                foundProject.get().setDescription(project.getDescription());
                foundProject.get().setCalculator(foundProject.get().getCalculator());
                projectRepository.save(foundProject.get());
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Author Name cannot be blank");
            }
        }
    }

    public void deleteProject(Long id) {
        Project projectFromDB = projectRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Project not found"));
        projectFromDB.setCalculator(null);
        projectRepository.save(projectFromDB);
            projectRepository.deleteById(id);
    }
}
