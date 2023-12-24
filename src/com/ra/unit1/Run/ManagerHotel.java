package com.ra.unit1.Run;

import com.ra.unit1.Entity.CurentTime;
import com.ra.unit1.Entity.Customer;
import com.ra.unit1.Entity.IManager;
import com.ra.unit1.Entity.Room;

import java.text.SimpleDateFormat;
import java.util.*;

public class ManagerHotel implements IManager {
    Scanner sc = new Scanner(System.in);
    public static List<Customer> customers = new ArrayList<>();
    public static List<Room> rooms = new ArrayList<>();
    public static Map<String,Float> roomTypes = new HashMap<>();
    public void add(){
        Customer customer = new Customer();
        customer.input(sc);
        customers.add(customer);
        rooms.forEach(r -> {
            if (r.getCustomer() == null){
                System.out.printf("%s | %s | %s | %s |\n",r.getNumber(),r.getType(),r.getPrice(),"Chưa có khách");
            } else {
                r.output();
            }
        });

            System.out.println("Nhập vào phòng muốn vào: ");
            String number = sc.nextLine();
            rooms.forEach(r -> {
                if (r.getNumber().equals(number)){
                    if (r.getCustomer()!= null){
                        System.out.println("Phòng đang có khách không thể thêm, chọn phòng khác: ");
                    } else {
                        r.setCustomer(customer);
                        checkIn(r);
                        System.out.println("Đã thêm phòng thành công");
                    }
                }
            });

    }

    @Override
    public void delete() {
        System.out.println("Nhập vào số CMND muốn xóa:");
        String id = sc.nextLine();
        customers.forEach(c -> {
            if (c.getId().equals(id)){
                customers.remove(c);
                System.out.println("Xóa thành công");
            }
        });
    }

    public void show(){
        System.out.printf("%10s | %15s | %8s |\n","Số CMND","Tên khách","Tuổi");
        customers.forEach(Customer::output);
        System.out.println("_________________________________________________________________________");
        System.out.printf("%8s | %12s | %12s | %15s | %15s |\n","Số phòng","Loại phòng","Giá phòng","Khách Thuê","Số ngày thuê");
        rooms.forEach(r -> {
            if (r.getCustomer() == null){
                System.out.printf("%8s | %12s | %8s USD | %15s | %15s |\n",r.getNumber(),r.getType(),r.getPrice(),"Chưa có khách",r.getRentday());
            } else {
                r.output();
            }
        });

    }
    public float calRent(double rentday,float price){
        return (float) rentday*price;
    }

    public void showByCMND(String id){
        int count = 0;
        for (Customer c:customers) {
            if (c != null){
                if (c.getId().equals(id)){
                    c.output();
                    count++;
                    break;
                }
            }
        }
        if (count == 0){
            System.err.println("CMND của khách không tồn tại");
        }

    }

    public void showByRoomNumber(String id){
        int count = 0;
        for (Room r:rooms) {
            if (r.getCustomer() != null){
                if (r.getNumber().equals(id)){
                    r.output();
                    count++;
                    break;
                }
            } else {
                System.out.printf("%s | %s | %s | %s | %s |\n",r.getNumber(),r.getType(),r.getPrice(),"Chưa có khách",r.getRentday());
                count++;
                break;
            }
        }
        if (count == 0){
            System.out.println("Phòng không tồn tại");
        }

    }

    public void checkIn(Room room){
        CurentTime curentTime = new CurentTime();
        curentTime.curentTime();
        room.setCheckInTime(curentTime.getCurrent());
    }

    public void checkOut(Room room){
        CurentTime curentTime = new CurentTime();
        curentTime.curentTime();
        room.setCheckOutTime(curentTime.getCurrent());

    }

}
