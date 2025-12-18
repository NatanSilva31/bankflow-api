package com.example.bankflow.repositories;

import com.example.bankflow.domain.user.User; // <--- O IMPORT TEM QUE SER ESSE
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);
}
