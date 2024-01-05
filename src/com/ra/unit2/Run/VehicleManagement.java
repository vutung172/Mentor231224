package com.ra.unit2.Run;

import com.ra.unit2.Entity.Vehicle;

import javax.sound.midi.MidiFileFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleManagement {
    List<Vehicle> vehicles = new ArrayList<>();
    private int count = 0;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public void add(Vehicle obj) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(obj.getId())) {
                System.err.println("Đối tượng đã tồn tại, không thế thêm");
                count++;
            }
        }
        if (count == 0){
            vehicles.add(obj);
            System.err.println("Thêm thành công");
        }
    }

    //Thêm method findById(String id) boolean

    public void delete(String id) {
        for (Vehicle v : vehicles) {
            if (v.getId().equals(id)) {
                vehicles.remove(v);
                System.err.println("Xóa thành công");
                count++;
                break;
            }
        }
        if (count == 0) {
            System.out.println("ID của đối tượng không tồn tại");
        }
    }

    public void show() {
        System.out.printf("%10s | %10s | %10s | %10s | %10s |\n", "ID", "Hãng", "Năm sản xuất", "Màu", "Giá");
        for (Vehicle v : vehicles) {
            System.out.printf("%10s | %10s | %10s | %10s | %10s |\n", v.getId(), v.getBrand(), v.getProductYear(), v.getColor(), v.getPrice());
        }
    }

    public void sortByPrice(String s) {
        switch (s) {
            case "ASC":
                /*if (vehicles != null) {*/
                //DÙng hàm sort (Sử dụng comparator)

                if (!vehicles.isEmpty()) {
                    for (int i = 0; i < vehicles.size(); i++) {
                        for (int j = i + 1; j < vehicles.size(); j++) {
                            if (vehicles.get(i).getPrice() > vehicles.get(j).getPrice()) {
                                Vehicle temp = vehicles.get(i);
                                vehicles.set(i, vehicles.get(j));
                                vehicles.set(j, temp);
                            }
                        }
                    }
                } else {
                    System.out.println("Chưa có phương tiện trong danh sách");
                }
                break;
            case "DESC":
                if (!vehicles.isEmpty()) {
                    for (int i = 0; i < vehicles.size(); i++) {
                        for (int j = i + 1; j < vehicles.size(); j++) {
                            if (vehicles.get(i).getPrice() < vehicles.get(j).getPrice()) {
                                Vehicle temp = vehicles.get(i);
                                vehicles.set(i, vehicles.get(j));
                                vehicles.set(j, temp);
                            }
                        }
                    }
                } else {
                    System.out.println("Chưa có phương tiện trong danh sách");
                }
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ");
        }
    }

    public <T> void searchByBrand(String s, T type) {
        for (Vehicle v : vehicles) {
            if (v.getClass().equals(type.getClass())) {
                if (v.getBrand().contains(s)) {
                    v.output();
                    count++;
                }
            }
        }
        if (count == 0){
            System.err.println("Hãng chưa có xe trong danh sách");
        }
    }

    public <T> void searchByColor(String s, T type) {
        for (Vehicle v : vehicles) {
            if (v.getClass().equals(type.getClass())) {
                if (v.getColor().contains(s)) {
                    v.output();
                    count++;
                }
            }
        }
        if (count == 0){
            System.err.println("Màu xe muốn tìm chưa có");
        }
    }

    public String selectType(Scanner sc) {
        System.out.println("Lựa chọn loại phương tiện: ");
        System.out.println("1. Xe oto");
        System.out.println("2. Xe Máy");
        System.out.println("3. Xe tải");
        System.out.println("Mời lựa chọn");
        int c = Integer.parseInt(sc.nextLine());
        switch (c) {
            case 1:
                return "Car";
            case 2:
                return "Motorbike";
            case 3:
                return "Truck";
            default:
                System.out.println("Lựa chọn không phù hợp");
        }
        return null;
    }
}
