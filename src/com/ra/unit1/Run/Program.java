package com.ra.unit1.Run;

import com.ra.unit1.Entity.Room;

import java.text.ParseException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        ManagerHotel managerHotel = new ManagerHotel();
        ManagerHotel.roomTypes.put("A",500F);
        ManagerHotel.roomTypes.put("B",300F);
        ManagerHotel.roomTypes.put("C",100F);

        Room room101 = new Room("A", 500F, "101");
        Room room102 = new Room("B", 300F, "102");
        Room room201 = new Room("C", 100F, "201");
        Room room202 = new Room("C", 100F, "202");
        Room room301 = new Room("B", 300F, "301");
        Room room302 = new Room("A", 500F, "302");
        ManagerHotel.rooms.add(room101);
        ManagerHotel.rooms.add(room102);
        ManagerHotel.rooms.add(room201);
        ManagerHotel.rooms.add(room202);
        ManagerHotel.rooms.add(room301);
        ManagerHotel.rooms.add(room302);

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("********Quản lý Khách sạn***********");
            System.out.println("1. Thêm người thuê phòng");
            System.out.println("2. Xóa người thuê theo CMND");
            System.out.println("3. Tính tiền người thuê theo CMND");
            System.out.println("4. Hiện thông tin theo CMND và phòng thuê");
            System.out.println("5. Hiện tất cả");
            System.out.println("6. Thoát");
            System.out.println("Nhập và lựa chọn (1-6)");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    managerHotel.add();


                    break;
                case 2:
                    managerHotel.delete();
                    break;
                case 3:
                    System.out.println("Nhập vào số CMND muốn tính tiền: ");
                    String id = sc.nextLine();
                    Room roomCheckOut = new Room();
                    System.out.printf("%s | %s | %s | %s | %s |\n","Số phòng","Loại phòng","Giá thuê","Tên khách","Thời gian check-in");
                    int count = 0;
                    for (Room r: ManagerHotel.rooms) {
                        if (r.getCustomer() != null){
                            if (r.getCustomer().getId().equals(id)){
                                System.out.printf("%s | %s | %s USD | %s | %s |\n",r.getNumber(),r.getType(),r.getPrice(),r.getCustomer().getName(),r.getCheckInTime());
                                count++;
                            }
                        }
                    }
                    if (count == 0) {
                        System.err.println("Khách thuê không tồn tại");
                    } else {
                        System.out.println("Chọn cách check out");
                        System.out.println("1. Check-ou tự động");
                        System.out.println("2. Nhập ngày dự định check-out");
                        int c = Integer.parseInt(sc.nextLine());
                        switch (c){
                            case 1:
                                System.out.printf("%8s | %8s | %13s | %15s | %20s | %20s | %8s | %10s |\n","Số phòng","Loại phòng","Giá thuê","Tên khách","Thời gian check-in","Thời gian check-out","Số ngày thuê","Tổng tiền");
                                for (Room r: ManagerHotel.rooms) {
                                    if (r.getCustomer() != null){
                                        if (r.getCustomer().getId().equals(id)){
                                            managerHotel.checkOut(r);
                                            r.calRent();
                                            System.out.printf("%8s | %8s | %s USD | %15s | %20s | %20s | %.1fs | %.3f USD |\n",r.getNumber(),r.getType(),r.getPrice(),r.getCustomer().getName(),r.getCheckInTime(),r.getCheckOutTime(),r.getRentday(),managerHotel.calRent(r.getRentday(),r.getPrice()));
                                        }
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Nhập ngày giờ trả phòng (dd-MM-yyyy HH:mm:ss)");
                                String checkOut = sc.nextLine();
                                System.out.printf("%8s | %12s | %10s | %15s | %20s | %20s | %8s | %14s |\n","Số phòng","Loại phòng","Giá thuê","Tên khách","Thời gian check-in","Thời gian check-out","Số ngày thuê","Tổng tiền");
                                for (Room r: ManagerHotel.rooms) {
                                    if (r.getCustomer() != null){
                                        if (r.getCustomer().getId().equals(id)){
                                            r.setCheckOutTime(checkOut);
                                            r.calRent();
                                            System.out.printf("%8s | %12s | %10s USD | %15s | %20s | %20s | %.1fs | %.3f USD |\n",r.getNumber(),r.getType(),r.getPrice(),r.getCustomer().getName(),r.getCheckInTime(),r.getCheckOutTime(),r.getRentday(),managerHotel.calRent(r.getRentday(),r.getPrice()));
                                        }
                                    }
                                }
                                break;
                            default:
                                System.out.println("Lựa chọn không phù hợp");
                        }
                    }
                    break;
                case 4:
                    System.out.println("Bạn muốn kiểm tra theo:");
                    System.out.println("1. Theo CMND");
                    System.out.println("2. Theo số phòng");
                    System.out.println("Nhập vào lựa chọn");
                    int c = Integer.parseInt(sc.nextLine());
                    switch (c){
                        case 1:
                            System.out.println("Nhập vào CMND muốn tìm: ");
                            String cmnd = sc.nextLine();
                            managerHotel.showByCMND(cmnd);
                            break;
                        case 2:
                            System.out.println("Nhập vào phòng muốn tìm; ");
                            String number = sc.nextLine();
                            managerHotel.showByRoomNumber(number);
                            break;
                        default:
                            System.out.println("số chọn không phù hợp");
                    }

                    break;
                case 5:
                    managerHotel.show();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        } while(true);
    }
}
