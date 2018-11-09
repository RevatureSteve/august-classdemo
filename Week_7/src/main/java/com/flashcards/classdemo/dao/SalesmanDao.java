package com.flashcards.classdemo.dao;


import com.flashcards.classdemo.entity.Salesman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesmanDao extends JpaRepository <Salesman, Integer> {
}
