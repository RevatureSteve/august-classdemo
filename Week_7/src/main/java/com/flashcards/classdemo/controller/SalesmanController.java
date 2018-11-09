package com.flashcards.classdemo.controller;


import com.flashcards.classdemo.entity.Salesman;
import com.flashcards.classdemo.service.SalesmanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

/**
 * SalesmanController
 * @Author: David
 */
@RestController
@RequestMapping("/salesman-api")
public class SalesmanController
{
    @Autowired
    SalesmanService service;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Salesman> getAllSalesman()
    {
        return service.getAllSalesman();
    }
    @GetMapping(value = "/salesman/{id}", produces = "application/json")
    public Optional<Salesman> getOne(@PathVariable Integer id)
    {
        return service.getSalesman(id);
    }

    /**
     * Post method for creating new Salesman
     * @param s
     * @Author: Julio Z
     * @return
     */
    @PostMapping(value = "/salesman", consumes = "application/json")
    public ResponseEntity addSalesman(@RequestBody Salesman s){
        service.createSalesman(s);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping(value= "/salesman/{id}" )
    public ResponseEntity updateSalesman(@PathVariable Integer id, @RequestBody Salesman s){
        s.setId(id);
        return new ResponseEntity(HttpStatus.valueOf(service.updateSalesman(s)));
    }

    @DeleteMapping(value = "/salesman/{id}")
    public ResponseEntity deleteSalesman(@PathVariable Integer id){
        if (service.deleteSalesman(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }

}
