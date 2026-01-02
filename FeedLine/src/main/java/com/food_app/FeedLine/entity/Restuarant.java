package com.food_app.FeedLine.entity;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "restuarant")
public class Restuarant {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;
    @Lob
    private String description;
    private String phone;
    private String email;
    private String address;

    private LocalTime opening_time;
    private LocalTime closing_time;
    private Boolean isOpen = true;

    private String banner;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getOpening_time() {
        return opening_time;
    }

    public void setOpening_time(LocalTime opening_time) {
        this.opening_time = opening_time;
    }

    public LocalTime getClosing_time() {
        return closing_time;
    }

    public void setClosing_time(LocalTime closing_time) {
        this.closing_time = closing_time;
    }

    public Boolean getOpen() {
        return isOpen;
    }

    public void setOpen(Boolean open) {
        isOpen = open;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
