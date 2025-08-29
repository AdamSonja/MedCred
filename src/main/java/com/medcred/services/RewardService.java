package com.medcred.services;

import com.medcred.contracts.RewardManager;
import com.medcred.models.Reward;
import com.medcred.repository.RewardRepository;
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
    private final RewardRepository rewardRepository;

    @Value("${contract.reward.address}")
    private String rewardAddress;

    private RewardManager rewardManager;

    @PostConstruct
    public void init() {
        rewardManager = RewardManager.load(rewardAddress, web3j, credentials, new DefaultGasProvider());
    }

    public Reward distributeRewardToDoctor(String doctorWallet, BigInteger baseReward) throws Exception {
        // Call Solidity's distributeReward()
        TransactionReceipt tx = rewardManager.distributeReward(doctorWallet, baseReward).send();

        Reward reward = new Reward();
        reward.setDoctorWallet(doctorWallet);
        reward.setAmount(baseReward);

        rewardRepository.save(reward);
        return reward;
    }
}
