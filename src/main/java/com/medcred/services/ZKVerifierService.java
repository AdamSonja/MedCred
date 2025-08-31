package com.medcred.services;

import com.medcred.contracts.ZKVerifierStub;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;

import jakarta.annotation.PostConstruct;
import java.math.BigInteger;

@Service
@RequiredArgsConstructor
public class ZKVerifierService {

    private final Web3j web3j;
    private final Credentials credentials;

    @Value("${contract.zkverifier.address}")
    private String zkVerifierAddress;

    private ZKVerifierStub zkVerifier;

    @PostConstruct
    public void init() {
        zkVerifier = ZKVerifierStub.load(zkVerifierAddress, web3j, credentials, new DefaultGasProvider());
    }

    public Boolean verifyProof(byte[] proof, BigInteger publicInput) throws Exception {
        return zkVerifier.verifyProof(proof, publicInput).send();
    }
}
