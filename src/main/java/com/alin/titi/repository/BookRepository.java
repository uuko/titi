package com.alin.titi.repository;

import com.alin.titi.model.LoginModel;
import com.alin.titi.model.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookModel, Integer> {
    BookModel findByInfNumber(Integer infNumber);
    List<BookModel> findByLoginModel(LoginModel loginModel);
}
