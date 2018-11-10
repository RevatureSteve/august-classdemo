package com.flashcards.classdemo.service;

import com.flashcards.classdemo.dao.FlashCardDao;
import com.flashcards.classdemo.dao.GeekDao;
import com.flashcards.classdemo.entity.FlashCard;
import com.flashcards.classdemo.entity.Geek;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * @author Nate
 */

@Service
@Transactional
public class GeekService {
    @Autowired
    GeekDao dao;

    @Transactional
    public Geek getGeek(Integer id){
        Optional<Geek> g = dao.findById(id);
        if (g.isPresent()){
            return g.get();
        }
        else {
            return null;
        }
    }

    @Transactional
    public List<Geek> getAllGeeks(){
        return dao.findAll();
    }

    @Transactional
    public boolean deleteGeek (Integer id){
        Optional<Geek> g = dao.findById(id);
        System.out.println("got in");
        if (g.isPresent()){
            System.out.println("got in1");

            dao.deleteById(id);
            return true;
        }
        else {
            System.out.println("got in2");

            return false;
        }
    }

    @Transactional
    public Integer updateGeek(Geek gk){
        Optional<Geek> g = dao.findById(gk.getId());

        try {
            if (g.isPresent()){
                if(g.get().equals(gk)){
                    System.out.println("got here");
                    return 204;
                } else {
                    System.out.println("updated");
                    dao.save(gk);
                    return 200;
                }
            }
            else{
                createGeek(gk);
                return 201;
            }
        } catch (Exception e){
            return 409;
        }
    }

    @Transactional
    public Integer createGeek(Geek gk){
        return dao.save(gk).getId();
    }


}
