package com.medcred.controllers;

import com.medcred.models.Reputation;
import com.medcred.services.ReputationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/reputation")
@RequiredArgsConstructor
public class ReputationController {

    private final ReputationService reputationService;

    /**
     * Mint a Reputation NFT for a doctor
     * @param wallet Doctor's wallet address
     * @param tokenId Unique token ID for the NFT
     * @param tokenURI Metadata URI for the NFT
     */
    @PostMapping("/mint")
    public Reputation mintReputation(@RequestParam String wallet,
                                     @RequestParam BigInteger tokenId,
                                     @RequestParam String tokenURI) throws Exception {
        return reputationService.mintReputationNFT(wallet, tokenId, tokenURI);
    }
}
