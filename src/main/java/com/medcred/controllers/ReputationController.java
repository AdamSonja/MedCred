package com.medcred.controllers;

import com.medcred.services.ReputationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@RestController
@RequestMapping("/reputation")
@RequiredArgsConstructor
public class ReputationController {

    private final ReputationService reputationService;

    @PostMapping("/mint")
    public TransactionReceipt mintReputation(@RequestParam String wallet,
                                             @RequestParam BigInteger tokenId,
                                             @RequestParam String tokenURI) throws Exception {
        return reputationService.mintReputationNFT(wallet, tokenId, tokenURI);
    }
}
