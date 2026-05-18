package com.fayda.identity.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "citizens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // --- CARD FRONT DESIGN DATA ---
    @Column(unique = true, nullable = false)
    private String dan; // Digital Account Number (12-digit public code on front)

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String sex;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private LocalDate dateOfIssue;

    @Column(nullable = false)
    private String photoUrl; // File path to the webcam capture file asset

    // --- CARD BACK DESIGN DATA ---
    @Column(unique = true, nullable = false)
    private String din; // Digital Identification Number (16-digit private code on back)

    @Column(nullable = false)
    private LocalDate dateOfExpiry;

    @Column(nullable = false)
    private String phoneNumber;

    @Embedded
    private Address address;

    // --- SYSTEM AUTOMATED EVALUATION TRACKERS ---
    @Column(nullable = false)
    private String verificationStatus; // OPTIONS: PENDING, APPROVED, REJECTED, BANNED

    @Column(columnDefinition = "TEXT")
    private String systemRemarks; // Logs the machine reasons (e.g., "Pass: High biometric confidence score")

    // --- RELATIONSHIPS ---
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}