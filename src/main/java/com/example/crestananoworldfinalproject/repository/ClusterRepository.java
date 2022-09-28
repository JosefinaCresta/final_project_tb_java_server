package com.example.crestananoworldfinalproject.repository;


import com.example.crestananoworldfinalproject.model.Cluster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClusterRepository extends JpaRepository<Cluster, Long> {
}
