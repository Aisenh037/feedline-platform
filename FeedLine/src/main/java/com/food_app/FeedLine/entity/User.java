package com.food_app.FeedLine.entity;

import com.food_app.FeedLine.entity.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    private String name;

    @Column(name = "mobile_no", unique = true,nullable = false)
    private String phone;
    @Column(unique = true,nullable = false)
    private String email;

    private String password;
    @Transient
    private String confirmPassword;
    private String address;

//    private String otp;
//    private String gender;
//    private String dob;

    @Enumerated(EnumType.STRING)
    private Role role;    //Admin, User, Delivery Boy

    private boolean isAvailable=true;   //For Deleivery Boy


//    private String city;
//    private String state;
//    private String country;
//    private int pincode;
//    private String profile_pic;
//    private String status;
    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Instant updatedAt;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch =  FetchType.LAZY)
    private List<Restuarant> restuarant = new ArrayList<>();

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirm_password() {
        return confirmPassword;
    }

    public void setConfirm_password(String confirm_password) {
        this.confirmPassword = confirm_password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdated_at(String updated_at) {
        this.updatedAt = updatedAt;
    }

    public List<Restuarant> getRestuarant() {
        return restuarant;
    }

    public void setRestuarant(List<Restuarant> restuarant) {
        this.restuarant = restuarant;
    }
}
