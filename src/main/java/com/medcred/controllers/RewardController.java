package com.medcred.controllers;

import com.medcred.models.Reward;
import com.medcred.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/reward")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;

    @PostMapping("/reward-doctor")
    public Reward rewardDoctor(@RequestParam String wallet, @RequestParam BigInteger amount) throws Exception {
        return rewardService.distributeRewardToDoctor(wallet, amount);
    }
}
