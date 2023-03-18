/**
 * Đây là lớp Manager kế thừa lớp Staff và thực hiện
 * interface ICalculator. Chứa thông tin của quản lý
 * gồm thuộc tính kế thừa của lớp Staff, bổ sung thêm
 * thuộc tính position cùng với getter và setter. Hơn nữa,
 * lớp cũng ghi đè phương thức displayInformation() và
 * thực hiện phương thức calculator().
 */
public class Manager  extends Staff implements ICalculator{
    private String position;

    /**
     * Đây là constructor của lớp Manager.
     * @param id tham số về mã của quản lý.
     * @param position tham số về vị trí làm việc.
     * @param name tham số về tên.
     * @param age tham số về tuổi.
     * @param factor tham số về hệ số lương.
     * @param startDate tham số về ngày bắt đầu làm.
     * @param department tham sô về phòng ban làm việc.
     * @param dayOff tham số về số ngày nghỉ.
     */
    public Manager(int id,String position , String name, int age, double factor, String startDate, String department,
                   int dayOff){
        setId(id);
        setPosition(position);
        setName(name);
        setAge(age);
        setFactor(factor);
        setStartDate(startDate);
        setDepartment(department);
        setDayOff(dayOff);
    }

    public void setPosition(String position){this.position = position;}
    public String getPosition(){return position;}

    /**
     * Đây là phương thức calculateSalary() thực hiện của interface
     * dùng để tính tiền lương của quản lý.
     * @return double, trả về tổng tiền lương kiểu double.
     */
    public double calculateSalary(){
        double salaryPosition = 0;
        switch (position){
            case "Business Leader":
                salaryPosition = 8000000;
                break;
            case "Project Leader":
                salaryPosition = 5000000;
                break;
            case  "Technical Leader":
                salaryPosition = 6000000;
                break;
        }
        return getFactor()*5000000 + salaryPosition;
    }

    /**
     * Đây là phương thức displayInformation(), ghi đè của lớp Staff
     * dùng để in ra thông tin của quản lý có bổ sung thêm vị trí làm việc.
     */
    public void displayInformation(){
        System.out.println("ID Manager: " + getId());
        System.out.println("Position: " + getPosition());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Factor: " + getFactor());
        System.out.println("Start Date: " + getStartDate());
        System.out.println("Department: " + getDepartment());
        System.out.println("Day off: " + getDayOff());
        System.out.println("Salary: " + String.format("%.2f",calculateSalary()));
        System.out.println();
    }
}
