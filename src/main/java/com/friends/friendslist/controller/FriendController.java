package com.friends.friendslist.controller;

import java.util.List;
import com.friends.friendslist.model.Friend;
import com.friends.friendslist.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin(origins = "http://localhost:3000") //frontend localhost can access
@RestController
@RequestMapping("/api/v1")
public class FriendController {
    @Autowired
    private FriendRepository friendRepository;

    //get
    @GetMapping("/friends")
    public List<Friend> getAllFriends() {
        return friendRepository.findAll();
    }

    //POST
    @PostMapping(value = "/friends")
    public Friend createFriend(@RequestBody Friend friend) {
        return friendRepository.save(friend);
    }


}


//get by ID
//    @GetMapping(value = "/friends/{id}")
//    public List<Friend> getAllFriends() {
//        return friendRepository.findAll();
//    }

