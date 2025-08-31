package com.medcred.controllers;

import com.medcred.services.MedCredRegistryService;
import com.medcred.services.MedCredRegistryService.DoctorDTO;
import org.springframework.web.bind.annotation.*;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import java.math.BigInteger;

@RestController
@RequestMapping("/api/registry")
public class MedCredRegistryController {

    private final MedCredRegistryService service;

    public MedCredRegistryController(MedCredRegistryService service) {
        this.service = service;
    }

    @PostMapping("/doctor/add")
    public TransactionReceipt addDoctor(@RequestParam String wallet,
                                        @RequestParam String license,
                                        @RequestParam String name) throws Exception {
        return service.addDoctor(wallet, license, name);
    }

    @PostMapping("/doctor/remove")
    public TransactionReceipt removeDoctor(@RequestParam String wallet) throws Exception {
        return service.removeDoctor(wallet);
    }

    @GetMapping("/doctor/{wallet}")
    public DoctorDTO getDoctor(@PathVariable String wallet) throws Exception {
        return service.getDoctor(wallet);
    }

    @GetMapping("/doctor/isRegistered")
    public boolean isDoctor(@RequestParam String wallet) throws Exception {
        return service.isDoctor(wallet);
    }

    @GetMapping("/walletByLicense")
    public String getWalletByLicense(@RequestParam String license) throws Exception {
        return service.getWalletByLicense(license);
    }

    @PostMapping("/reputation/increase")
    public TransactionReceipt increaseReputation(@RequestParam String wallet, @RequestParam BigInteger points) throws Exception {
        return service.increaseReputation(wallet, points);
    }

    @PostMapping("/reputation/decrease")
    public TransactionReceipt decreaseReputation(@RequestParam String wallet, @RequestParam BigInteger points) throws Exception {
        return service.decreaseReputation(wallet, points);
    }

    @PostMapping("/reputation/set")
    public TransactionReceipt setReputation(@RequestParam String wallet, @RequestParam BigInteger value) throws Exception {
        return service.setReputation(wallet, value);
    }

    @GetMapping("/reputation")
    public BigInteger getReputation(@RequestParam String wallet) throws Exception {
        return service.getReputation(wallet);
    }

    @PostMapping("/ownership/transfer")
    public TransactionReceipt transferOwnership(@RequestParam String newOwner) throws Exception {
        return service.transferOwnership(newOwner);
    }

    @PostMapping("/roles/grant")
    public TransactionReceipt grantReputationManager(@RequestParam String wallet) throws Exception {
        return service.grantReputationManager(wallet);
    }

    @PostMapping("/roles/revoke")
    public TransactionReceipt revokeReputationManager(@RequestParam String wallet) throws Exception {
        return service.revokeReputationManager(wallet);
    }
}
