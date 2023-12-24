package com.ra.unit1.Entity;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer implements IHotel{
    private String id;
    private String name;
    private int age;

    public Customer() {
    }

    public Customer(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void input(Scanner sc) {
        do {
            System.out.println("Nhập vào số CMND: ");
            this.id = sc.nextLine();
            if (!isValid("[\\d]{9}",this.id)){
                System.err.println("Số CMND không hợp lệ");
            }
        } while (!isValid("[\\d]{9}",this.id));
        System.out.println("Nhập vào tên khách: ");
        this.name = sc.nextLine();
        System.out.println("Nhập vào tuổi: ");
        this.age = Integer.parseInt(sc.nextLine());
    }

    @Override
    public void output() {
        System.out.printf("%10s | %15s | %8s |\n",this.id,this.name,this.age);
    }

    public <V> boolean isValid(String type, V value){
        Pattern p = Pattern.compile(type);
        Matcher m = p.matcher((CharSequence) value);
        return m.matches();
    }
}
