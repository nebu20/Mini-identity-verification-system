package com.fayda.identity.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "system_rules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SystemRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String ruleKey; // e.g., "MIN_BIOMETRIC_SCORE", "BLOCK_DUPLICATE_NAMES"

    @Column(nullable = false)
    private String ruleValue; // e.g., "0.85", "true"

    @Column(nullable = false)
    private boolean isActive = true;

    private String description;
}