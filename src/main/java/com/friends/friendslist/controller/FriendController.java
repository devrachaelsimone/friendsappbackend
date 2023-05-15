package com.friends.friendslist.controller;

import java.util.List;
import com.friends.friendslist.model.Friend;
import com.friends.friendslist.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


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
}
