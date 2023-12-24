package com.ra.unit2.Entity;

import java.util.Scanner;

public class Vehicle implements IVehicle{
    private String id;
    private String brand;
    private String productYear;
    private String color;
    private double price;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProductYear() {
        return productYear;
    }

    public void setProductYear(String productYear) {
        this.productYear = productYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void input(Scanner sc) {
        System.out.println("Nhập vào mã: ");
        this.id = sc.nextLine();
        System.out.println("Nhập vào hãng xe: ");
        this.brand = sc.nextLine();
        System.out.println("Nhập vào năm sản xuất");
        this.productYear = sc.nextLine();
        System.out.println("Nhập vào màu xe: ");
        this.color = sc.nextLine();
        System.out.println("Nhập vào giá: ");
        this.price = Double.parseDouble(sc.nextLine());
    }

    @Override
    public void output() {
    }




}
