package com.alin.titi.repository;

import com.alin.titi.model.PaperModel;
import com.alin.titi.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Integer> {
    PasswordResetToken findByToken(String token);
}
