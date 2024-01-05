package com.friends.friendslist.controller;

import com.friends.friendslist.model.Friend;
import com.friends.friendslist.model.MailModel;
import com.friends.friendslist.repository.FriendRepository;
import com.friends.friendslist.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //frontend localhost can access
@RestController
@RequestMapping("/api/v1")
public class MailController {
    @Autowired
    private MailRepository mailRepository;

    //get
    @GetMapping("/sendmail")
    public List<MailModel> getAllSentMail() {
        return mailRepository.findAll();
    }

    //POST
    @PostMapping(value = "/sendmail")
    public ResponseEntity<?> createMail(@RequestBody MailModel mail) {
        // Set physical mail-specific fields to null
        if (mail.isDigital()) {
            mail.setStatus(null);
            mail.setPriorityShipping(null);
            mail.setContents(null);
            mail.setWeight(null);
        } else {
            // Handle physical mail logic, set digital fields to null
            mail.setBody(null);
            mail.setDigital(false);
        }
        //setPriorityShipping - boolean
        //setWeight - double


        // Save the mail
        mailRepository.save(mail);

        // Return a success response
        return ResponseEntity.ok("Mail sent successfully");
    }
}
