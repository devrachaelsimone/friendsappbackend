package com.friends.friendslist.repository;

import com.friends.friendslist.model.MailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<MailModel, Long> {
}
