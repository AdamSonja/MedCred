package com.medcred.models;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigInteger;

@Entity
@Data
public class Reputation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String doctorWallet;

    // Add these fields to track minted NFT
    private BigInteger tokenId;
    private String tokenURI;
}
