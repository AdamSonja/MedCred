package com.medcred.services;

import com.medcred.contracts.MedCredRegistery;
import com.medcred.models.Doctor;
import com.medcred.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.protocol.core.methods.response.TransactionReceipt;

import jakarta.annotation.PostConstruct;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final Web3j web3j;
    private final Credentials credentials;
    private final DoctorRepository doctorRepository;

    @Value("${contract.registry.address}")
    private String registryAddress;

    private MedCredRegistery registry;

    @PostConstruct
    public void init() {
        registry = MedCredRegistery.load(registryAddress, web3j, credentials, new DefaultGasProvider());
    }

    public Doctor addDoctor(String wallet, String license, String name) throws Exception {
        TransactionReceipt tx = registry.addDoctor(wallet, license, name).send();

        Doctor doctor = new Doctor();
        doctor.setWalletAddress(wallet);
        doctor.setLicense(license);
        doctor.setName(name);

        doctorRepository.save(doctor);

        return doctor;
    }

    public String getOwner() throws Exception {
        return registry.owner().send();
    }
}
