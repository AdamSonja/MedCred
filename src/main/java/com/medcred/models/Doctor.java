package com.medcred.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Doctor {
    @Id
    private String license;

    private String name;

    private String walletAddress; // ADD THIS
}
