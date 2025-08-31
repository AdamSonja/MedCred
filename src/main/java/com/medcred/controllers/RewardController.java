package com.medcred.controllers;

import com.medcred.services.RewardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@RestController
@RequestMapping("/reward")
@RequiredArgsConstructor
public class RewardController {

    private final RewardService rewardService;

    @PostMapping("/reward-doctor")
    public TransactionReceipt rewardDoctor(@RequestParam String wallet, @RequestParam BigInteger amount) throws Exception {
        return rewardService.distributeRewardToDoctor(wallet, amount);
    }

    @PostMapping("/slash-doctor")
    public TransactionReceipt slashDoctor(@RequestParam String wallet, @RequestParam BigInteger amount) throws Exception {
        return rewardService.slashDoctor(wallet, amount);
    }

    @PostMapping("/set-max-boost")
    public TransactionReceipt setMaxBoost(@RequestParam int bps) throws Exception {
        return rewardService.setMaxBoost(bps);
    }
}
