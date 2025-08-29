package com.medcred.controllers;

import com.medcred.models.DoctorStake;
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
    public DoctorStake stakeTokens(@RequestParam String license, @RequestParam BigInteger amount) throws Exception {
        return stakingService.stakeTokens(license, amount);
    }

    @PostMapping("/withdraw")
    public String withdrawStake() throws Exception {
        stakingService.withdrawStake();
        return "Stake withdrawn!";
    }
}
