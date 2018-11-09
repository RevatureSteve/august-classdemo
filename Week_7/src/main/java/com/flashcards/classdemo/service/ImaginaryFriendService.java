package com.flashcards.classdemo.service;

import com.flashcards.classdemo.dao.ImaginaryFriendDao;
import com.flashcards.classdemo.entity.ImaginaryFriend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Creates services for the imaginary friend
 *
 * @@author Christina
 * @author Jon
 * @author Felipe
 */

@Service
@Transactional
public class ImaginaryFriendService {
    @Autowired
    ImaginaryFriendDao dao;

    @Transactional
    public ImaginaryFriend getFriend(Integer id){
        Optional<ImaginaryFriend> f = dao.findById(id);
        if (f.isPresent()){
            return f.get();
        }
        else {
            return null;
        }
    }

    @Transactional
    public List<ImaginaryFriend> getAllFriends(){
        return dao.findAll();
    }

    @Transactional
    public boolean deleteFriend (Integer id){
        Optional<ImaginaryFriend> f = dao.findById(id);
        if (f.isPresent()){
            dao.deleteById(id);
            return true;
        }
        else {
            return false;
        }
    }

    @Transactional
    public Integer updateFriends(ImaginaryFriend fc){
        Optional<ImaginaryFriend> f = dao.findById(fc.getId());

        try {
            if (f.isPresent()){
                if(f.get().equals(fc)){
                    return 204;
                } else {
                    dao.save(fc);
                    return 200;
                }
            }
            else{
                createFriends(fc);
                return 201;
            }
        } catch (Exception e){
            return 409;
        }
    }

    @Transactional
    public Integer createFriends(ImaginaryFriend fc){
        return dao.save(fc).getId();
    }
}

