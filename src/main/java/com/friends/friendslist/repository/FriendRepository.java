package com.friends.friendslist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.friends.friendslist.model.Friend;

@Repository
public interface FriendRepository extends JpaRepository<Friend, Long> {

}
