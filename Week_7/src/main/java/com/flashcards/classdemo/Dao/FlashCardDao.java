package com.flashcards.classdemo.Dao;

import com.flashcards.classdemo.Entity.FlashCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashCardDao extends JpaRepository<FlashCard, Integer> {
}
