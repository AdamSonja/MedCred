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

    // Add a doctor on-chain. walletAddress must be a hex address (e.g. "0xabc...").
    public TransactionReceipt addDoctorOnChain(String walletAddress, String license, String name) throws Exception {
        return registry.addDoctor(walletAddress, license, name).send();
    }

    // Get wallet by license
    public String getWalletByLicense(String license) throws Exception {
        return registry.getWalletByLicense(license).send();
    }

    // Check doctor
    public boolean isDoctor(String walletAddress) throws Exception {
        return registry.isDoctor(walletAddress).send();
    }

    // Increase reputation on-chain (requires REPUTATION_MANAGER_ROLE or ADMIN)
    public TransactionReceipt increaseReputationOnChain(String walletAddress, BigInteger points) throws Exception {
        return registry.increaseReputation(walletAddress, points).send();
    }

    // Get reputation
    public BigInteger getReputationOnChain(String walletAddress) throws Exception {
        // wrapper returns BigInteger
        return registry.getReputation(walletAddress).send();
    }
}
