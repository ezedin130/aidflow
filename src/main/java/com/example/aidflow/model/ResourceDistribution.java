package com.example.aidflow.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResourceDistribution {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String resourceName;
    @Column(nullable = false)
    private int quantity;
    //beneficiary verified
    //verification code
    @Column(nullable = false)
    private LocalDateTime distributedAt;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    @JoinColumn(name = "project_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @Column(nullable = false)
    @JoinColumn(name = "ngo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ngo ngo;
}
