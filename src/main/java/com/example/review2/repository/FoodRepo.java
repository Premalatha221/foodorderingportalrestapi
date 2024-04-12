package com.example.review2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.review2.model.Food;

public interface FoodRepo extends JpaRepository<Food,Integer> 
{
    @Query("SELECT f FROM Food f WHERE f.price > 300")
    List<Food> findByPrice();
}