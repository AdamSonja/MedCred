package com.medcred.services;

import com.medcred.contracts.ReputationNFT;
import com.medcred.models.Reputation;
import com.medcred.repository.ReputationRepository;
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
public class ReputationService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final ReputationRepository reputationRepository;

    @Value("${contract.reputation.address}")
    private String reputationAddress;

    private ReputationNFT reputation;

    @PostConstruct
    public void init() {
        reputation = ReputationNFT.load(reputationAddress, web3j, credentials, new DefaultGasProvider());
    }

    public Reputation mintReputationNFT(String doctorWallet, BigInteger tokenId, String tokenURI) throws Exception {
        // Mint NFT as reputation
        TransactionReceipt tx = reputation.mint(doctorWallet, tokenId, tokenURI).send();

        Reputation rep = new Reputation();
        rep.setDoctorWallet(doctorWallet);
        rep.setTokenId(tokenId);
        rep.setTokenURI(tokenURI);

        reputationRepository.save(rep);

        return rep;
    }
}
