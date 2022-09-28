package com.example.crestananoworldfinalproject.controller;


import com.example.crestananoworldfinalproject.DTO.ClusterDTO;
import com.example.crestananoworldfinalproject.model.Cluster;
import com.example.crestananoworldfinalproject.repository.ClusterRepository;
import com.example.crestananoworldfinalproject.service.impl.ClusterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClusterController {
    @Autowired
    private ClusterService clusterService;

    @Autowired
    private ClusterRepository clusterRepository;

    @GetMapping("/clusters")
    @ResponseStatus(HttpStatus.OK)
    public List<Cluster> getClusters() {
        return clusterRepository.findAll();
    }

    @PostMapping("/clusters")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCluster(@RequestBody ClusterDTO cluster){
        clusterService.saveCluster(cluster);
    }

    @DeleteMapping("/clusters/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCluster(@PathVariable Long id){
        clusterService.deleteCluster(id);
    }
}

