package com.flashcards.classdemo.dao;

import com.flashcards.classdemo.entity.Comedian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComedianDao extends CrudRepository <Comedian,Integer> {
}
