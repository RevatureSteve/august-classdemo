package com.flashcards.classdemo.controller;

import com.flashcards.classdemo.entity.Comedian;
import com.flashcards.classdemo.service.ComedianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@RequestMapping("/comedian-api")
public class ComedianController {

    ComedianService service;

    @Autowired
    public ComedianController(ComedianService service){this.service = service; }

    @GetMapping(value = "/comedian/{id}")
    public Comedian getComedian(@PathVariable Integer id) {return service.getComedian(id);}


    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Comedian> getAllComedian() {return service.getAllComedians();}


    @DeleteMapping(value = "/comedian/{id}")
    public ResponseEntity deleteComedian(@PathVariable Integer id){
        if(service.deleteComedian(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/comedian/{id}")
    public ResponseEntity updateComedian (@PathVariable Integer id, @RequestBody Comedian co){
        co.setId(id);

        switch(service.updateComedian(co)){
            case 204:
                return  new ResponseEntity(HttpStatus.NO_CONTENT);
            case 200:
                return  new ResponseEntity(HttpStatus.OK);
            case 201:
                return new ResponseEntity(HttpStatus.CREATED);
            case 409:
                return new ResponseEntity(HttpStatus.CONFLICT);
            default:
                return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

        @PostMapping(value = "/comedian")
        public ResponseEntity addComedian(@RequestBody Comedian co, HttpServletResponse resp){
            service.createComedian(co);
            resp.setHeader("Location", "http://localhost:8080/comedian" + co.getId());
            return new ResponseEntity(HttpStatus.CREATED);
        }



}
