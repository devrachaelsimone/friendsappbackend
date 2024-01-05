package com.friends.friendslist.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "friend")
public class Friend implements Sender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "stream")
    private String stream;
    @Column(name = "email")
    private String email;

    //create sender relationship between friend and mail
    @OneToMany(mappedBy = "friendSender", cascade = CascadeType.ALL)
    private List<MailModel> sentMails = new ArrayList<>();

    //should this be same method as what is used in mailRepository.findall?
    public List<MailModel> getSentMails() {
        return sentMails;
    }

    // ============= CONSTRUCTOR
    public Friend() {
    }

    // ========================= COPY CONSTRUCTOR
    public Friend(long id, String name, String address, String stream, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stream = stream;
        this.email = email;
    }

    // =========================  ID
    @Override //from sender interface
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //regular getters and setters =================================

    // =========================   NAME
    @Override //from sender interface
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // =========================  ADDRESS
    @Override //from sender interface
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // =========================  STREAM
    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    // =========================  EMAIL
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
