package com.example.review2.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Food {
   
    @Id
    private int fid;
    
    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }
     
    
     private String foodcategory;
     private String foodname;
     private String hotel;
     private String phno;
     private String address;
     private int pincode;
     private int price;
    public Food() {
    }

    public Food(int fid, String foodcategory, String foodname, String hotel, String phno, String address, int pincode,
            int price) {
        this.fid = fid;
        this.foodcategory = foodcategory;
        this.foodname = foodname;
        this.hotel = hotel;
        this.phno = phno;
        this.address = address;
        this.pincode = pincode;
        this.price = price;
    }

    

    public String getFoodcategory() {
        return foodcategory;
    }

    public void setFoodcategory(String foodcategory) {
        this.foodcategory = foodcategory;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getPhno() {
        return phno;
    }

    public void setPhno(String phno) {
        this.phno = phno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
   
   
  @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="orders_orderid")
    @JsonBackReference
    private  Orders order;

public Orders getOrder() {
    return order;
}

public void setOrder(Orders order) {
    this.order = order;
}


    

  

    
}