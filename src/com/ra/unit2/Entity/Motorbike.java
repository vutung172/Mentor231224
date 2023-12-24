package com.ra.unit2.Entity;

import java.util.Scanner;

public class Motorbike extends Vehicle{
    private int power;

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.println("Nhập vào công suất xe: ");
        this.power = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.printf("%s | %s | %s | %s | %s | %s |\n",getId(),getBrand(),getProductYear(),getColor(),getPower(),getPrice());
    }
}
