package com.medcred.repository;

import com.medcred.models.DoctorStake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorStakeRepository extends JpaRepository<DoctorStake, Long> {
}
