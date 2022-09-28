package com.example.crestananoworldfinalproject.service.interfaces;


import com.example.crestananoworldfinalproject.DTO.ClusterDTO;

public interface ClusterServiceInterface {

    void saveCluster(ClusterDTO cluster);

    void deleteCluster(Long id);
}
