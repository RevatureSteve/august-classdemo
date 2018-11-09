package com.flashcards.classdemo.dao;

/**
 * @author Joe
 *
 */

import com.flashcards.classdemo.entity.Geek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeekDao extends JpaRepository<Geek, Integer > {
}
