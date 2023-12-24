package com.ra.unit2.Run;

import com.ra.unit2.Entity.Car;
import com.ra.unit2.Entity.Motorbike;
import com.ra.unit2.Entity.Truck;

import java.util.Scanner;
import java.util.TreeMap;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        VehicleManagement vm = new VehicleManagement();
        do {
            System.out.println("***********Quản lý phương tiện giao thông************");
            System.out.println("1. Thêm phương tiện");
            System.out.println("2. Xóa phương tiện");
            System.out.println("3. Hiển thị danh sách");
            System.out.println("4. Sắp xếp giá bán tăng dần");
            System.out.println("5. Sắp xếp giá bán giảm dần");
            System.out.println("6. Tìm theo hãng sản xuất");
            System.out.println("7. Tìm theo màu xe");
            System.out.println("8. Thoát");
            System.out.println("Mời bạn chọn (1-8)");
            int c = Integer.parseInt(sc.nextLine());
            switch (c){
                case 1:
                    String select;
                    do {
                        String type =  vm.selectType(sc);
                        switch (type){
                            case "Car":
                                Car car = new Car();
                                car.input(sc);
                                vm.add(car);
                                break;
                            case "Motorbike":
                                Motorbike motorbike  = new Motorbike();
                                motorbike.input(sc);
                                vm.add(motorbike);
                                break;
                            case "Truck":
                                Truck truck = new Truck();
                                truck.input(sc);
                                vm.add(truck);
                                break;
                            default:
                                System.out.println("Không hợp lệ");
                        }
                        System.out.println("Bạn có muốn tiếp tục (Y/N)");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("Y"));
                    break;
                case 2:
                    System.out.println("Nhập vào Id muốn xóa: ");
                    String id = sc.nextLine();
                    vm.delete(id);
                    break;
                case 3:
                    vm.show();
                    break;
                case 4:
                    vm.sortByPrice("ASC");
                    break;
                case 5:
                    vm.sortByPrice("DESC");
                    break;
                case 6:

                    do {
                        String type = vm.selectType(sc);
                        System.out.println("Nhập vào tên hãng muốn tìm: ");
                        String name = sc.nextLine();
                        switch (type){
                            case "Car":
                                Car car = new Car();
                                vm.searchByBrand(name,car);
                                break;
                            case "Motorbike":
                                Motorbike motorbike  = new Motorbike();
                                vm.searchByBrand(name,motorbike);
                                break;
                            case "Truck":
                                Truck truck = new Truck();
                                vm.searchByBrand(name,truck);
                                break;
                            default:
                                System.out.println("Không hợp lệ");
                        }
                        System.out.println("Bạn có muốn tiếp tục(Y/N)");
                        select = sc.nextLine();
                    } while(select.equalsIgnoreCase("Y"));
                    break;
                case 7:
                    do {
                        String type = vm.selectType(sc);
                        System.out.println("Nhập vào tên màu muốn tìm: ");
                        String name = sc.nextLine();
                        switch (type){
                            case "Car":
                                Car car = new Car();
                                vm.searchByColor(name,car);
                                break;
                            case "Motorbike":
                                Motorbike motorbike  = new Motorbike();
                                vm.searchByColor(name,motorbike);
                                break;
                            case "Truck":
                                Truck truck = new Truck();
                                vm.searchByColor(name,truck);
                                break;
                            default:
                                System.out.println("Không hợp lệ");
                        }
                        System.out.println("Bạn có muốn tiếp tục (Y/N):");
                        select = sc.nextLine();
                    } while (select.equalsIgnoreCase("Y"));
                    break;
                case 8:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không phù hợp");
            }
        }while(true);
    }
}
