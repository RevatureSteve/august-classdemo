package com.flashcards.classdemo.dao;

import com.flashcards.classdemo.entity.Deck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeckDao extends JpaRepository<Deck, Integer> {
}