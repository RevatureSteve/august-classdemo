package com.flashcards.classdemo.controller;

import com.flashcards.classdemo.entity.Geek;
import com.flashcards.classdemo.service.GeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author Agustin
 *
 */
@RestController
@RequestMapping("/geek-api")
public class GeekController {
    GeekService service;

    @Autowired
    public GeekController(GeekService service){this.service= service;}
    @GetMapping(value="/geek/{id}", produces="application/json")
    public Geek getOneGeek (@PathVariable Integer id){return service.getGeek(id);}

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Geek> getAllGeeks(){
        return service.getAllGeeks();
    }

    @DeleteMapping(value = "/geek/{id}")
    public ResponseEntity deleteGeek(@PathVariable Integer id){
        if (service.deleteGeek(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("/geek/{id}")
    public ResponseEntity updateGeek (@PathVariable Integer id, @RequestBody Geek g){

        g.setId(id);
        return new ResponseEntity(HttpStatus.valueOf(service.updateGeek(g)));
    }

    @PostMapping(value = "/geek", consumes = "application/json")
    public ResponseEntity addGeek(@RequestBody Geek g, HttpServletResponse resp) {
        service.createGeek(g);
        resp.setHeader("Location", "http://localhost:8080/geek" + g.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}







