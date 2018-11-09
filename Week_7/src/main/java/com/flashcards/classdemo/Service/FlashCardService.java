package com.flashcards.classdemo.Service;

import com.flashcards.classdemo.Dao.FlashCardDao;
import com.flashcards.classdemo.Entity.FlashCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FlashCardService {
    @Autowired
    FlashCardDao dao;

//    @Autowired
//    public FlashCardService(FlashCardDao dao) {
//        this.dao = dao;
//    }

    @Transactional
    public FlashCard getFlashCard(Integer id){
        Optional<FlashCard> f = dao.findById(id);
        if (f.isPresent()){
            return f.get();
        }
        else {
            return null;
        }
    }

    @Transactional
    public List<FlashCard> getAllFlashCards(){
        return dao.findAll();
    }

    @Transactional
    public boolean deleteFlashCard (Integer id){
        Optional<FlashCard> f = dao.findById(id);
        System.out.println("got in");
        if (f.isPresent()){
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
    public Integer updateFlashCard(FlashCard fc){
        Optional<FlashCard> f = dao.findById(fc.getId());

        try {
            if (f.isPresent()){
                if(f.get().equals(fc)){
                    System.out.println("got here");
                    return 204;
                } else {
                    System.out.println("updated");
                    dao.save(fc);
                    return 200;
                }
            }
            else{
                createFlashCard(fc);
                return 201;
            }
        } catch (Exception e){
            return 409;
        }
    }

    @Transactional
    public Integer createFlashCard(FlashCard fc){
        return dao.save(fc).getId();
    }
}
