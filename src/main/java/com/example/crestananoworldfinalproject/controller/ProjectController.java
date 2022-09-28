package com.example.crestananoworldfinalproject.controller;


import com.example.crestananoworldfinalproject.DTO.ProjectDTO;
import com.example.crestananoworldfinalproject.model.Project;
import com.example.crestananoworldfinalproject.repository.ProjectRepository;
import com.example.crestananoworldfinalproject.service.impl.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectService projectService;

    @GetMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Project getProjectById(@PathVariable(name = "id") Long projectId) {
        return projectService.findById(projectId);
    }

    @GetMapping("/projects")
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    @PostMapping("/projects")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProject(@RequestBody ProjectDTO project){
        projectService.saveProject(project);
    }

    @PatchMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProject(@PathVariable Long id,@RequestBody Project project){
        projectService.update(id, project);
    }

    @DeleteMapping("/projects/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProject(id);
    }
}