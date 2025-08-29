package com.medcred.controllers;

import com.medcred.services.ZKVerifierService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.Base64;

@RestController
@RequestMapping("/zk")
@RequiredArgsConstructor
public class ZKVerifierController {

    private final ZKVerifierService zkVerifierService;

    @PostMapping("/verify")
    public Boolean verifyProof(@RequestParam String proof, @RequestParam String publicSignal) throws Exception {
        // Convert proof string (assume Base64 encoded) to byte[]
        byte[] proofBytes = Base64.getDecoder().decode(proof);

        // Convert publicSignal to BigInteger
        BigInteger publicInput = new BigInteger(publicSignal);

        return zkVerifierService.verifyProof(proofBytes, publicInput);
    }
}
