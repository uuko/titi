package com.alin.titi.repository;

import com.alin.titi.model.AuthorModel;
import com.alin.titi.model.RegisterTeacherModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<AuthorModel, Integer> {
}
