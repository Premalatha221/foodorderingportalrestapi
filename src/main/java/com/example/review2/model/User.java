package com.example.review2.model;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
     @Id
     private int eid;
     public int getEid() {
      return eid;
    }
    public void setEid(int eid) {
      this.eid = eid;
    }
    private String name;
    private String email;
    

    public User() {
    }
    
    public User(int eid, String name, String email) {
        this.eid = eid;
        this.name = name;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    // @OneToMany(mappedBy = "users", cascade = CascadeType.ALL, orphanRemoval = true)
    // @JsonManagedReference
    // private List<Food> FoodDetails = new ArrayList<>();
    // public List<Food> getFoodDetails() {
    //     return FoodDetails;
    // }
    // public void setFoodDetails(List<Food> FoodDetails) {
    //     this.FoodDetails = FoodDetails;
    // }

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Orders> orderdata=new ArrayList<>();
    public List<Orders> getOrderdata() {
        return orderdata;
    }
    public void setOrderdata(List<Orders> orderdata) {
        this.orderdata = orderdata;
    }

    
    
}