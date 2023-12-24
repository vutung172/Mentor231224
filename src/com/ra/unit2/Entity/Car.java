package com.ra.unit2.Entity;

import java.util.Scanner;

public class Car extends Vehicle{
    private int seat;
    private String engine;

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.println("Nhập số ghế: ");
        this.seat = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập vào loại động cơ: ");
        this.engine = sc.nextLine();
    }

    @Override
    public void output() {
        System.out.printf("%s | %s | %s | %s | %s | %s | %s |\n",getId(),getBrand(),getProductYear(),getColor(),getEngine(),getSeat(),getPrice());
    }
}
