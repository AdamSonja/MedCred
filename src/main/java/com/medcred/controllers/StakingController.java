package com.medcred.controllers;

import com.medcred.services.StakingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/staking")
@RequiredArgsConstructor
public class StakingController {

    private final StakingService stakingService;

    @PostMapping("/stake")
    public String stakeTokens(@RequestParam BigInteger amount) throws Exception {
        stakingService.stakeTokens(amount);
        return "Tokens staked successfully!";
    }

    @PostMapping("/unstake")
    public String requestUnstake(@RequestParam BigInteger amount) throws Exception {
        stakingService.requestUnstake(amount);
        return "Unstake requested! Wait for cooldown.";
    }

    @PostMapping("/withdraw")
    public String withdrawStake() throws Exception {
        stakingService.withdrawStake();
        return "Stake withdrawn successfully!";
    }

    @GetMapping("/staked")
    public BigInteger getStakedAmount(@RequestParam String wallet) throws Exception {
        return stakingService.getStakedAmount(wallet);
    }
}
