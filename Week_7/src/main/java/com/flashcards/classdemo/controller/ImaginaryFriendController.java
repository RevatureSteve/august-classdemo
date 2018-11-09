package com.flashcards.classdemo.controller;

import com.flashcards.classdemo.entity.ImaginaryFriend;
import com.flashcards.classdemo.service.ImaginaryFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * creates controller for imaginary friends
 *
 * @author Christina
 * @author Jon
 * @author Felipe
 */


@RestController
@RequestMapping("/imaginary-api")
public class ImaginaryFriendController {
    @Autowired
    ImaginaryFriendService service;

    @GetMapping(value = "/friend/{id}", produces = "application/json")
    public ImaginaryFriend getOneFriend (@PathVariable Integer id) {
        return service.getFriend(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ImaginaryFriend> getAllFriends(){
        return service.getAllFriends();
    }

    @DeleteMapping(value = "/friend/{id}")
    public ResponseEntity deleteFriend(@PathVariable Integer id){
        if (service.deleteFriend(id)){
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }

    @PutMapping("/friend/{id}")
    public ResponseEntity updateFriends (@PathVariable Integer id, @RequestBody ImaginaryFriend fc){
        fc.setId(id);
        return new ResponseEntity(HttpStatus.valueOf(service.updateFriends(fc)));

    }

    @PostMapping(value = "/friend", consumes = "application/json")
    public ResponseEntity addFriends(@RequestBody ImaginaryFriend fc, HttpServletResponse resp) {
        service.createFriends(fc);
        resp.setHeader("Location", "http://localhost:8080/friend" + fc.getId());
        return new ResponseEntity(HttpStatus.CREATED);
    }
}

