package com.flashcards.classdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.flashcards.classdemo.entity.FlashCard;
import com.flashcards.classdemo.service.FlashCardService;

/**
 * 
 * @author skels
 * @author skels2
 *
 */
@RestController
@RequestMapping("/flashcard-api")
public class FlashController {
	
    FlashCardService service;

    @Autowired
    public FlashController(FlashCardService service) {
        this.service = service;
    }

    /**
     *  Returns a FlashCard JSON object by the param id
     * @param id
     * @return
     */
    @GetMapping(value = "/flashcard/{id}", produces = "application/json")
    public FlashCard getOneFlashCard (@PathVariable Integer id) {
        return service.getFlashCard(id);
    }

    /*
     *  Could/Should just be GetMapping for consistency 
     */
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FlashCard> getAllFlashCard(){
        return service.getAllFlashCards();
    }

    @DeleteMapping(value = "/flashcard/{id}")
    public ResponseEntity deleteFlashCard(@PathVariable Integer id){
        if (service.deleteFlashCard(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
//            return new ResponseEntity(HttpStatus.valueOf(204));
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
//            return new ResponseEntity(HttpStatus.valueOf(404));

        }

    }

    @PutMapping("/flashcard/{id}")
    public ResponseEntity updateFlashCard (@PathVariable Integer id, @RequestBody FlashCard fc){
        //service.updateFlashCard(fc);
        fc.setId(id);
//        next line is optional instead of switch statement
//        return new ResponseEntity(HttpStatus.valueOf(service.updateFlashCard(fc)));
        switch (service.updateFlashCard(fc)){
            case 204:
                return new ResponseEntity(HttpStatus.NO_CONTENT);
            case 200:
                return new ResponseEntity(HttpStatus.OK);
            case 201:
                return new ResponseEntity(HttpStatus.CREATED);
            case 409:
                return new ResponseEntity(HttpStatus.CONFLICT);
            default:
                return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @PostMapping(value = "/flashcard", consumes = "application/json")
    public ResponseEntity addFlashCard(@RequestBody FlashCard fc, HttpServletResponse resp) {
        service.createFlashCard(fc);
        resp.setHeader("Location", "http://localhost:8080/flashcard" + fc.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
