package com.friends.friendslist.repository;

import com.friends.friendslist.model.FamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.friends.friendslist.model.Friend;

@Repository
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long>{

}
