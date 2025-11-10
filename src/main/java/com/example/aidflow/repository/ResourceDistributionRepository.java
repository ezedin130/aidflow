package com.example.aidflow.repository;

import com.example.aidflow.model.ResourceDistribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceDistributionRepository extends JpaRepository<ResourceDistribution,Long> {
}
