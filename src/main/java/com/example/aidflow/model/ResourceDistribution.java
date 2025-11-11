package com.example.aidflow.model;

import com.example.aidflow.constant.ResourceUnitType;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String resourceName;
    @Column(nullable = false)
    private double quantity;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ResourceUnitType unitType;
    @Column(nullable = false)
    private LocalDateTime createdAt;
    @JoinColumn(name = "project_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;
    @JoinColumn(name = "ngo_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ngo ngo;
}
