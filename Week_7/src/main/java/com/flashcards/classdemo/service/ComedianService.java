package com.flashcards.classdemo.service;

import com.flashcards.classdemo.dao.ComedianDao;
import com.flashcards.classdemo.entity.Comedian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ComedianService {

    @Autowired
    ComedianDao dao;

    /**
     * VERIFY THAT GET COMEDIAN ID IS VALID
     *
     * @param id
     * @return
     */
    @Transactional
    public Comedian getComedian(Integer id){
        Optional<Comedian> comic = dao.findById(id);

        return comic.get();
    }

    @Transactional
    public List<Comedian> getAllComedians(){
        Iterable<Comedian> comics = dao.findAll();

        List<Comedian> target = new ArrayList<>();
        comics.forEach(target::add);
        return target;
    }

    @Transactional
    public boolean deleteComedian(Integer id){
        Optional<Comedian> comic = dao.findById(id);
        if(comic.isPresent() ){
            dao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Integer updateComedian(Comedian update){
        Optional<Comedian> comic = dao.findById(update.getId() );

        try {
            if (comic.isPresent() ){
                if(comic.get().equals(update) ) {
                    return 204;
                }else{
                    dao.save(update);
                    return 200;
                }
            }else{
                createComedian(update);
                return 201;
            }
        } catch(Exception omg){
            return 409;
        }
    }

    @Transactional
    public Integer createComedian(Comedian comic){
        return dao.save(comic).getId();
    }

}
