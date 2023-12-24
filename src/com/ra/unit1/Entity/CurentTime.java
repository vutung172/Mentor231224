package com.ra.unit1.Entity;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Year;
import java.util.Date;

public class CurentTime {
    private String current;

    public CurentTime() {
    }

    public String getCurrent() {
        return current;
    }

    public void setCurrent(String current) {
        this.current = current;
    }

    public void curentTime(){
        Long curentTime = System.currentTimeMillis();
        SimpleDateFormat simpleDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date(curentTime);
        this.current = simpleDate.format(date);
    }
}
