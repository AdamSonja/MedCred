package com.medcred.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Data
public class Reward {
    @Id
    @GeneratedValue
    private Long id;

    private String doctorWallet;

    private BigInteger amount;
}
