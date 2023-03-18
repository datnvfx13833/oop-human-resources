/**
 * Đây là chương trình HumanResources dùng để
 * 1. Hiển thị danh sách nhân viên hiện có trong công ty
 * 2. Hiển thị các bộ phận trong công ty
 * 3. Hiển thị các nhân viên theo từng bộ phận
 * 4. Thêm nhân viên mới vào công ty
 * 5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
 * 6. Hiển thị bảng lương của nhân viên toàn công ty
 * 7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
 */

import java.util.*;

public class HumanResources {
    /**
     * Đây là phương thức main xử lý chính của chương trình.
     * Chứa vòng lặp các chức năng cho người dùng sử dụng
     * @param args
     */
    public static void main(String[] args){
        String tiepTuc = "";
        do {
            chucNang();
            thucHien();
            System.out.println("Bạn còn yêu cầu: nhấn Y, kết thúc: nhấn N");
            tiepTuc = sc.next();
        }while (tiepTuc.equals("Y"));
    }

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Staff> listStaff = new ArrayList<>();
    static ArrayList<Department> listDepartment = new ArrayList<>();
    static int yeuCau;

    /**
     * Đây là phương thức chucNang(), không có kiểu trả về.
     * Dùng để đưa ra các yêu cầu để người dùng lựa chọn và
     * lưu lựa chọn vào biến yeuCau.
     */
    public static void chucNang(){
        System.out.println("Bạn muốn làm gì?");
        System.out.println("Thêm nhân viên mới? Nhấn 1");
        System.out.println("Hiển thị danh sách nhân viên hiện có? Nhấn 2");
        System.out.println("Hiển thị các bộ phận trong công ty? Nhấn 3");
        System.out.println("Hiển thị các nhân viên theo từng bộ phận? Nhấn 4");
        System.out.println("Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên? Nhấn 5");
        System.out.println("Hiển thị bảng lương của nhân viên toàn công ty? Nhấn 6");
        System.out.println("Hiển thị bảng lương của nhân viên theo thứ tự tăng dần? Nhấn 7");
        yeuCau = sc.nextInt();
    }

    /**
     * Đây là phương thức thực hiện các yêu cầu cảu người sử dụng
     * chứa mệnh đề switch theo biến yeuCau với các case từ 1 đến 7
     */
    public static void thucHien(){
       switch (yeuCau){
           /**
            * Đây là trường hợp ứng với yêu cầu Thêm nhân viên mới.
            */
           case 1:
               String tiepTuc = "";
               do {
                   System.out.println("Them nhan vien: Nhấn 1, thêm quản lý nhấn 0");
                   int laNhanVien = sc.nextInt();

                   if(laNhanVien == 1){
                       System.out.println("Nhập id nhân viên: ");
                       int id = sc.nextInt();
                       System.out.println("Nhập tên nhân viên: ");
                       String name = sc.next();
                       System.out.println("Nhập tuổi nhân viên: ");
                       int age = sc.nextInt();
                       System.out.println("Nhập hệ số lương: ");
                       double factor = sc.nextDouble();
                       System.out.println("Nhập ngày vào làm: ");
                       String startDate = sc.next();
                       System.out.println("Nhập bộ phận làm việc: ");
                       String department = sc.next();
                       System.out.println("Nhập số ngày nghỉ: ");
                       int dayOff = sc.nextInt();
                       System.out.println("Nhập số giờ làm thêm: ");
                       int overtimeHours = sc.nextInt();
                       Employee employee = new Employee(id,name, age, factor, startDate, department, dayOff, overtimeHours);
                       listStaff.add(employee);

                       boolean has = false;
                       for(int i = 0; i < listDepartment.size(); i++){
                           if(has = listDepartment.get(i).getName().equals(department)){
                               listDepartment.get(i).setNumberStaff(listDepartment.get(i).getNumberStaff()+1);
                               break;
                           }
                       }
                       if(!has){
                           Department department1 = new Department(0,department,1);
                           listDepartment.add(department1);
                       }
                   }else {
                       System.out.println("Nhập id quản lý: ");
                       int id = sc.nextInt();
                       System.out.println("Nhập vị trí làm việc: ");
                       String position = sc.next();
                       System.out.println("Nhập tên quản lý: ");
                       String name = sc.next();
                       System.out.println("Nhập tuổi quản lý: ");
                       int age = sc.nextInt();
                       System.out.println("Nhập hệ số lương: ");
                       double factor = sc.nextDouble();
                       System.out.println("Nhập ngày vào làm: ");
                       String startDate = sc.next();
                       System.out.println("Nhập bộ phận làm việc: ");
                       String department = sc.next();
                       System.out.println("Nhập số ngày nghỉ: ");
                       int dayOff = sc.nextInt();
                       Manager manager = new Manager(id, position, name, age, factor,startDate,department,dayOff);
                       listStaff.add(manager);

                       boolean has = false;
                       for(int i = 0; i < listDepartment.size(); i++){
                           if(has = listDepartment.get(i).getName().equals(department)){
                               listDepartment.get(i).setNumberStaff(listDepartment.get(i).getNumberStaff()+1);
                               break;
                           }
                       }
                       if(!has){
                           Department department1 = new Department(0,department,1);
                           listDepartment.add(department1);
                       }

                   }
                   System.out.println("Tiếp tục nhập: nhấn Y, kết thúc nhập: nhấn N");
                   tiepTuc = sc.next();
               }while (tiepTuc.equals("Y"));
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Hiển thị danh sách nhân viên hiện có
            */
           case 2:
               for(int i = 0; i < listStaff.size();i++){
                   listStaff.get(i).displayInformation();
               }
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Hiển thị danh sách nhân viên hiện có
            */
           case 3:
               for(int i = 0; i < listDepartment.size();i++){
                   listDepartment.get(i).toString();
               }
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Hiển thị các bộ phận trong công ty
            */
           case 4:
               for(int i = 0; i < listDepartment.size(); i++){
                   System.out.println("Cac nhan vien trong bo phan " + listDepartment.get(i).getName() + " la:");
                   for(int j = 0; j < listStaff.size(); j++){
                       if(listStaff.get(j).getDepartment().equals(listDepartment.get(i).getName())){
                           listStaff.get(j).displayInformation();
                       }
                   }
               }
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên
            */
           case 5:
               System.out.println("Tìm nhân viên theo tên: Nhấn 1, tìm theo id: Nhấn 0");
               int luaChon = sc.nextInt();
               if(luaChon == 1){
                   System.out.println("Nhập tên cần tìm: ");
                   String name = sc.next();
                   for (int i = 0; i < listStaff.size();i++){
                       if(listStaff.get(i).getName().equals(name)){
                           listStaff.get(i).displayInformation();
                       }
                   }
               }else {
                   System.out.println("Nhập id cần tìm: ");
                   int id = sc.nextInt();
                   for (int i = 0; i < listStaff.size();i++){
                       if(listStaff.get(i).getId() == id){
                           listStaff.get(i).displayInformation();
                       }
                   }
               }
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Hiển thị bảng lương của nhân viên toàn công ty (giảm dần)
            */
           case 6:
               Comparator<Staff> descendingSalaryComparator = Collections.reverseOrder(new StaffSalaryComparator());
               Collections.sort(listStaff, descendingSalaryComparator);
               for(int i = 0; i < listStaff.size();i++){
                   listStaff.get(i).displayInformation();
               }
           break;

           /**
            * Đây là trường hợp ứng với yêu cầu Hiển thị bảng lương của nhân viên theo thứ tự tăng dần
            */
           case 7:
               Collections.sort(listStaff, new StaffSalaryComparator());
               for(int i = 0; i < listStaff.size();i++){
                   listStaff.get(i).displayInformation();
               }
           break;
       }
    }

    /**
     * Đây là lớp StaffSalaryComparator thực hiện interface Comparator
     */
    public static class StaffSalaryComparator implements Comparator<Staff> {
        /**
         * Đây là phương thức copmare được ghi đè
         * @param emp1 tham số đối tượng Staff thứ nhất.
         * @param emp2 tham số đối tường Staff thứ hai.
         * @return int, trả về so sánh theo lương của 2 đối tượng kiểu int.
         */
        public int compare(Staff emp1, Staff emp2) {
            return (int) (((ICalculator)emp1).calculateSalary() -((ICalculator)emp2).calculateSalary());
        }
    }
}
