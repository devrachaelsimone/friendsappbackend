package com.friends.friendslist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Friend")
public class Friend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="address")
    private String address;
    @Column(name="stream")
    private String stream;
    @Column(name="email")
    private String email;

    // ============= CONSTRUCTOR
    public Friend(){
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
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
// =========================   NAME

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // =========================  ADDRESS
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
