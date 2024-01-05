package com.friends.friendslist.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "family")
public class FamilyMember implements Sender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "relation")
    private String relation;
    @Column(name = "email")
    private String email;

    //create sender relationship between familyMember and mail
    @OneToMany(mappedBy = "familyMemberSender", cascade = CascadeType.ALL)
    private List<MailModel> sentMails = new ArrayList<>();

    public List<MailModel> getSentMails() {
        return sentMails;
    }

    // ============= CONSTRUCTOR
    public FamilyMember() {
    }

    // ========================= COPY CONSTRUCTOR
    public FamilyMember(long id, String name, String address, String relation, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.relation = relation;
        this.email = email;
    }

    @Override //from sender interface
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    //regular getters and setters =================================

    // =========================   NAME
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    // =========================  ADDRESS
    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // =========================  RELATION

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
    // =========================  EMAIL

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
