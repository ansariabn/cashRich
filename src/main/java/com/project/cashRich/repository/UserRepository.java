package com.project.cashRich.repository;

import com.project.cashRich.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
/**
 * @author Nehal Ansari
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // i added Multiple methods for more understanding
//    additional methods for better undersatnding
    boolean existsByEmail(String email);

    boolean existsByUsername(String username);

    void deleteByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
}
