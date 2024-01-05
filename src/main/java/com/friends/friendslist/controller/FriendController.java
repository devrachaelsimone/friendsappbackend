package com.friends.friendslist.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.friends.friendslist.exception.ResourceNotFoundException;
import com.friends.friendslist.model.Friend;
import com.friends.friendslist.repository.FriendRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@CrossOrigin("*") //frontend localhost can access
@RestController
@RequestMapping("/api/v1")
public class FriendController {
    private static Logger logger = LoggerFactory.getLogger(FriendController.class);


    @Autowired
    private FriendRepository friendRepository;

    //get
    @GetMapping("/friends")
    public List<Friend> getAllFriends() {
        logger.info("Successfully fetched all friends ");
        logger.info("--------------------------------");

        return friendRepository.findAll();
    }


    //POST
    @PostMapping(value = "/friends")
    public Friend createFriend(@RequestBody Friend friend) {
        return friendRepository.save(friend);
    }

    //DELETE
    @DeleteMapping(value = "/friend/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteFriend(@PathVariable Long id) {
        Friend friend = friendRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("A friend with the id of " + id + " does not exist."));
        friendRepository.delete(friend);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);













    }



}


//get by ID
//    @GetMapping(value = "/friends/{id}")
//    public List<Friend> getAllFriends() {
//        return friendRepository.findAll();
//    }







































