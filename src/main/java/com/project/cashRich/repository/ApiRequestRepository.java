package com.project.cashRich.repository;

import com.project.cashRich.model.Api3dParty;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @author Nehal Ansari
 */
public interface ApiRequestRepository extends JpaRepository<Api3dParty, Long> {
    // Additional methods if needed
}
