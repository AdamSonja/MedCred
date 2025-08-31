package com.medcred.repository;

import com.medcred.models.Reputation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReputationRepository extends JpaRepository<Reputation, String> {
}
