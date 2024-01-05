package com.friends.friendslist.model;
import jakarta.persistence.*;


@Entity
@Table(name = "Mail")

public class MailModel {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //digital only fields=========================================
    @Column(name = "is_digital" , nullable = true)
    private Boolean isDigital;

    @Column(name = "body" , nullable = true)
    private String body;

    //physical only fields=========================================
    @Column(name = "status" , nullable = true)
    private String status;

    @Column(name = "is_priority_shipping" , nullable = true)
    private Boolean isPriorityShipping;

    @Column(name = "weight" , nullable = true)
    private Double weight;

    @Column(name = "contents",  nullable = true)
    private String contents;

    //mapping fields for friends and family (sender) =======================
    //friend
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, insertable=false, updatable=false)
    private Friend friendSender;

    //family
    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false, insertable=false, updatable=false)
    private FamilyMember familyMemberSender;


    // Setter for sender, you can choose either Friend or FamilyMember
    public void setSender(Object sender) {
        if (sender instanceof Friend) {
            this.friendSender = (Friend) sender;
            this.familyMemberSender = null;
        } else if (sender instanceof FamilyMember) {
            this.familyMemberSender = (FamilyMember) sender;
            this.friendSender = null;
        } else {
            // Handle invalid sender type or throw an exception
            System.out.println("error in mail model due to sender type");
        }
    }


        //constructors ===========================================
   public MailModel(Boolean isDigital, String body, String status, Boolean isPriorityShipping, Double weight, String contents, Friend friendSender) {
            this.isDigital = isDigital;
            this.body = body;
            this.status = status;
            this.isPriorityShipping = isPriorityShipping;
            this.weight = weight;
            this.contents = contents;
            this.friendSender = friendSender;
        }

    public MailModel(Boolean isDigital, String body, String status, Boolean isPriorityShipping, Double weight, String contents, FamilyMember familyMemberSender) {
            this.isDigital = isDigital;
            this.body = body;
            this.status = status;
            this.isPriorityShipping = isPriorityShipping;
            this.weight = weight;
            this.contents = contents;
            this.familyMemberSender = familyMemberSender;
        }
    public MailModel() {

        }












//regular getters and setters==================================
public Long getId() {
    return id;
}

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isDigital() {
        return isDigital;
    }

    public void setDigital(Boolean digital) {
        isDigital = digital;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean isPriorityShipping() {
        return isPriorityShipping;
    }

    public void setPriorityShipping(Boolean priorityShipping) {
        isPriorityShipping = priorityShipping;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Friend getFriendSender() {
        return friendSender;
    }

//    public void setFriendSender(Friend friendSender) {
//        this.friendSender = friendSender;
//    }

    public FamilyMember getFamilyMemberSender() {
        return familyMemberSender;
    }

//    public void setFamilyMemberSender(FamilyMember familyMemberSender) {
//        this.familyMemberSender = familyMemberSender;
//    }



}
