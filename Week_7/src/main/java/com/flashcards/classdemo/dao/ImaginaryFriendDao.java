package com.flashcards.classdemo.dao;
/**
 * Imaginary Friend Dao
 * @author Felipe
 * @author Christina
 * @author Jon
 */

import com.flashcards.classdemo.entity.ImaginaryFriend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImaginaryFriendDao extends JpaRepository<ImaginaryFriend, Integer> {
}

