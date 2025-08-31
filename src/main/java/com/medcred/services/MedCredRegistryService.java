package com.medcred.services;

import com.medcred.contracts.MedCredRegistery;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import jakarta.annotation.PostConstruct;
import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class MedCredRegistryService {

    private final Web3j web3j;
    private final Credentials credentials;

    @Value("${contract.registry.address}")
    private String registryAddress;

    private MedCredRegistery registry;

    @PostConstruct
    public void init() {
        registry = MedCredRegistery.load(registryAddress, web3j, credentials, new DefaultGasProvider());
    }

    // === Doctor Management ===
    public TransactionReceipt addDoctor(String walletAddress, String license, String name) throws Exception {
        return registry.addDoctor(walletAddress, license, name).send();
    }

    public TransactionReceipt removeDoctor(String walletAddress) throws Exception {
        return registry.removeDoctor(walletAddress).send();
    }

    public boolean isDoctor(String walletAddress) throws Exception {
        return registry.isDoctor(walletAddress).send();
    }

    public String getWalletByLicense(String license) throws Exception {
        return registry.getWalletByLicense(license).send();
    }

    public DoctorDTO getDoctor(String walletAddress) throws Exception {
        var result = registry.getDoctor(walletAddress).send();
        return new DoctorDTO(result.getValue1(), result.getValue2(), result.getValue3());
    }

    // === Reputation Management ===
    public TransactionReceipt increaseReputation(String walletAddress, BigInteger points) throws Exception {
        return registry.increaseReputation(walletAddress, points).send();
    }

    public TransactionReceipt decreaseReputation(String walletAddress, BigInteger points) throws Exception {
        return registry.decreaseReputation(walletAddress, points).send();
    }

    public TransactionReceipt setReputation(String walletAddress, BigInteger value) throws Exception {
        return registry.setReputation(walletAddress, value).send();
    }

    public BigInteger getReputation(String walletAddress) throws Exception {
        return registry.getReputation(walletAddress).send();
    }

    // === Ownership / Roles ===
    public TransactionReceipt transferOwnership(String newOwner) throws Exception {
        return registry.transferOwnership(newOwner).send();
    }

    public TransactionReceipt grantReputationManager(String walletAddress) throws Exception {
        return registry.grantReputationManager(walletAddress).send();
    }

    public TransactionReceipt revokeReputationManager(String walletAddress) throws Exception {
        return registry.revokeReputationManager(walletAddress).send();
    }

    // === DTO for Doctor ===
    public static class DoctorDTO {
        public final String license;
        public final String name;
        public final boolean exists;

        public DoctorDTO(String license, String name, boolean exists) {
            this.license = license;
            this.name = name;
            this.exists = exists;
        }
    }
}
