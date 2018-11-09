package com.flashcards.classdemo.service;

import com.flashcards.classdemo.dao.DeckDao;
import com.flashcards.classdemo.dao.FlashCardDao;
import com.flashcards.classdemo.entity.Deck;
import com.flashcards.classdemo.entity.FlashCard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DeckService {
    @Autowired
    DeckDao dao;

    public Deck getDeck(Integer id){
        Optional<Deck> d = dao.findById(id);
        if (d.isPresent()){
            return d.get();
        }
        else {
            return null;
        }
    }

    public List<Deck> getAllDecks(){
        return dao.findAll();
    }

    public boolean deleteDeck (Integer id){
        Optional<Deck> d = dao.findById(id);
        System.out.println("got in");
        if (d.isPresent()){
            System.out.println("got in1");

            dao.deleteById(id);
            return true;
        }
        else {
            System.out.println("got in2");

            return false;
        }
    }

    public Integer updateDeck(Deck sd){
        Optional<Deck> d = dao.findById(sd.getId());

        try {
            if (d.isPresent()){
                if(d.get().equals(sd)){
                    System.out.println("got here");
                    return 204;
                } else {
                    System.out.println("updated");
                    dao.save(sd);
                    return 200;
                }
            }
            else{
                createDeck(sd);
                return 201;
            }
        } catch (Exception e){
            return 409;
        }
    }

    public Integer createDeck(Deck d){
        return dao.save(d).getId();
    }
}