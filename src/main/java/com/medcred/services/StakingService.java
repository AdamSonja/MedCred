package com.medcred.services;

import com.medcred.contracts.Staking;
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

    @Value("${contract.staking.address}")
    private String stakingAddress;

    private Staking staking;

    @PostConstruct
    public void init() {
        staking = Staking.load(stakingAddress, web3j, credentials, new DefaultGasProvider());
    }

    // Stake tokens
    public TransactionReceipt stakeTokens(BigInteger amount) throws Exception {
        return staking.stake(amount).send();
    }

    // Request unstake (starts cooldown)
    public TransactionReceipt requestUnstake(BigInteger amount) throws Exception {
        return staking.requestUnstake(amount).send();
    }

    // Withdraw tokens after cooldown
    public TransactionReceipt withdrawStake() throws Exception {
        return staking.withdraw().send();
    }

    // View staked amount of a wallet
    public BigInteger getStakedAmount(String walletAddress) throws Exception {
        return staking.getStaked(walletAddress).send();
    }
}
