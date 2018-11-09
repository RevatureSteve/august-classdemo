package com.flashcards.classdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flashcards.classdemo.entity.FlashCard;

@Repository
public interface FlashCardDao extends JpaRepository<FlashCard, Integer> {
}
