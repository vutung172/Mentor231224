package com.ra.unit1.Entity;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Room implements IHotel{
    private String type;
    private float price;
    private String number;
    private Customer customer;
    private String checkInTime;
    private String checkOutTime;
    private double rentday;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public Room() {
    }

    public Room(String type, float price, String number) {
        this.type = type;
        this.price = price;
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getRentday() {
        return rentday;
    }

    public void setRentday(double rentday) {
        this.rentday = rentday;
    }

    @Override
    public void input(Scanner sc) {

    }

    @Override
    public void output() {
        System.out.printf("%8s | %10s | %8s | %15s | %20s | %20s | %.1f |\n",this.number,this.type,this.price,this.customer.getName(),this.checkInTime,this.checkOutTime,this.rentday);
    }

    public void calRent() throws ParseException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime checkOut = LocalDateTime.parse(this.checkOutTime,dtf);
        LocalDateTime checkIn = LocalDateTime.parse(this.checkInTime,dtf);
        long millisCheckOut = checkOut.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
        long millisCheckIn = checkIn.atZone(java.time.ZoneId.systemDefault()).toInstant().toEpochMilli();
        this.rentday = (double) (millisCheckOut - millisCheckIn) /86400000;
    }
}
