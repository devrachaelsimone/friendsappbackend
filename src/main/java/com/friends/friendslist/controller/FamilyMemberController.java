package com.friends.friendslist.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.friends.friendslist.exception.ResourceNotFoundException;
import com.friends.friendslist.model.FamilyMember;

import com.friends.friendslist.repository.FamilyMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*") //frontend localhost can access

@RestController
@RequestMapping("/api/v1")
public class FamilyMemberController {
    @Autowired
    private FamilyMemberRepository familyMemberRepository;

    //get
    @GetMapping("/familymembers")
    public List<FamilyMember> getAllFamilyMembers() {
        return familyMemberRepository.findAll();
    }


    @PostMapping(value = "/familymembers")
    public FamilyMember createFamilyMember(@RequestBody FamilyMember familyMember) {
        return familyMemberRepository.save(familyMember);
    }

    //DELETE
//    @DeleteMapping(value = "/familymember/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteFamilyMember(@PathVariable Long id) {
//        FamilyMember familyMember = familyMemberRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("A familymember with the id of " + id + " does not exist."));
//        friendRepository.delete(friend);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }



}


//get by ID
//    @GetMapping(value = "/friends/{id}")
//    public List<Friend> getAllFriends() {
//        return friendRepository.findAll();
//    }







































