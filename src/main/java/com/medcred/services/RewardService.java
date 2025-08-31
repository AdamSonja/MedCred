package com.medcred.services;

import com.medcred.contracts.ReputationManagerFixed;
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
public class RewardService {

    private final Web3j web3j;
    private final Credentials credentials;

    @Value("${contract.reward.address}")
    private String rewardAddress;

    private ReputationManagerFixed rewardManager;

    @PostConstruct
    public void init() {
        rewardManager = ReputationManagerFixed.load(rewardAddress, web3j, credentials, new DefaultGasProvider());
    }

    public TransactionReceipt distributeRewardToDoctor(String doctorWallet, BigInteger baseReward) throws Exception {
        // Calls the smart contract directly
        return rewardManager.distributeReward(doctorWallet, baseReward).send();
    }

    public TransactionReceipt slashDoctor(String doctorWallet, BigInteger amount) throws Exception {
        return rewardManager.slash(doctorWallet, amount).send();
    }

    public TransactionReceipt setMaxBoost(int bps) throws Exception {
        return rewardManager.setMaxBoostBps(BigInteger.valueOf(bps)).send();
    }
}
