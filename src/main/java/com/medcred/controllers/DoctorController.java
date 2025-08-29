package com.medcred.controllers;

import com.medcred.models.Doctor;
import com.medcred.services.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.regex.Pattern;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    private static final Pattern ETH_ADDRESS_PATTERN = Pattern.compile("^0x[a-fA-F0-9]{40}$");

    @PostMapping("/add")
    public ResponseEntity<?> addDoctor(
            @RequestParam String wallet,
            @RequestParam String license,
            @RequestParam String name
    ) {
        try {
            if (!ETH_ADDRESS_PATTERN.matcher(wallet).matches()) {
                return ResponseEntity.badRequest().body("Invalid Ethereum wallet address");
            }

            Doctor doctor = doctorService.addDoctor(wallet, license, name);
            return ResponseEntity.ok(doctor);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error adding doctor: " + e.getMessage());
        }
    }

    @GetMapping("/owner")
    public ResponseEntity<?> getOwner() {
        try {
            String owner = doctorService.getOwner();
            return ResponseEntity.ok(owner);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error fetching owner: " + e.getMessage());
        }
    }
}
