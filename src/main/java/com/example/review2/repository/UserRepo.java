package com.example.review2.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.review2.model.User;



public interface UserRepo extends JpaRepository<User,Integer> {

}