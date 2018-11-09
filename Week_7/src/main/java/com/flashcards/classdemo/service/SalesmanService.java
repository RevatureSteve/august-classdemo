package com.flashcards.classdemo.service;


import com.flashcards.classdemo.dao.SalesmanDao;
import com.flashcards.classdemo.entity.Salesman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class SalesmanService {

    @Autowired
    SalesmanDao salesmanDao;

    @Transactional
    public Optional<Salesman> getSalesman(Integer id){      //if doesn't work blame steve
        Optional<Salesman> s = salesmanDao.findById(id);
        return s;
    }

    /**
     * Returns all Salesman
     * @author Jose
     * @return
     */
    @Transactional
    public List<Salesman> getAllSalesman(){
        return salesmanDao.findAll();
    }

    /**
     * Deletes a Salesman
     * @author Jose
     * @return
     */
    @Transactional
    public boolean deleteSalesman (Integer id) {
        Optional<Salesman> s = salesmanDao.findById(id);
        if(s.isPresent()) {
            salesmanDao.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Create a Salesman
     * @param s
     * @author Kevin Z.
     * @return
     */
    @Transactional
    public Integer createSalesman (Salesman s){return salesmanDao.save(s).getId();}


    /**
     * Update Salesman
     * @param s
     * @return
     * @author Kevin Z.
     */
    @Transactional
    public Integer updateSalesman(Salesman s){
        Optional <Salesman> salesman = salesmanDao.findById(s.getId());

        try{
            if (salesman.isPresent()){
                if (salesman.get().equals(s)){
                    return 204;
                }else {
                    salesmanDao.save(s);
                    return 200;}
            }else{
                createSalesman(s);
                return 201;
            }
        }catch(Exception e){
            return 409;
        }

        }



}
