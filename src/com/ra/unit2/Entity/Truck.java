package com.ra.unit2.Entity;

import java.util.Scanner;

public class Truck extends Vehicle{
    private int maxWeight;

    public int getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    @Override
    public void input(Scanner sc) {
        super.input(sc);
        System.out.println("Nhập vào trọng tải tối đa: ");
        this.maxWeight = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        super.output();
        System.out.printf("%s | %s | %s | %s | %s | %s |\n",getId(),getBrand(),getProductYear(),getColor(),getMaxWeight(),getPrice());
    }
}
