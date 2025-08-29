package com.medcred.services;

import com.medcred.contracts.Staking;
import com.medcred.models.DoctorStake;
import com.medcred.repository.StakingRepository;
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
public class StakingService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final StakingRepository stakingRepository;

    @Value("${contract.staking.address}")
    private String stakingAddress;

    private Staking staking;

    @PostConstruct
    public void init() {
        staking = Staking.load(stakingAddress, web3j, credentials, new DefaultGasProvider());
    }

    public DoctorStake stakeTokens(String doctorWallet, BigInteger amount) throws Exception {
        TransactionReceipt tx = staking.stake(amount).send(); // calls contract stake()

        DoctorStake stake = new DoctorStake();
        stake.setDoctorWallet(doctorWallet);
        stake.setAmount(amount);
        stakingRepository.save(stake);

        return stake;
    }

    public void withdrawStake() throws Exception {
        staking.withdraw().send(); // msg.sender withdraws their stake
    }
}
