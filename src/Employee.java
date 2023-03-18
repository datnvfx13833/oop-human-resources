/**
 * Đây là lớp Employee kế thừa lớp Staff và thực hiện
 * interface ICalculator. Chứa thông tin của nhân viên
 * gồm thuộc tính kế thừa của lớp Staff, bổ sung thêm
 * thuộc tính overtimeHours cùng với getter và setter.
 * Hơn nữa, lớp cũng ghi đè phương thức displayInformation()
 * và thực hiện phương thức calculator().
 */
public class Employee extends Staff implements ICalculator{
    private int overtimeHours;

    /**
     * Đây là constructor của lớp Employee
     * @param id tham số về mã của nhân viên.
     * @param name tham số về tên của nhân viên.
     * @param age tham số về tuổi của nhân viên.
     * @param factor tham số về hệ số lương.
     * @param startDate tham số về ngày bắt đầu làm.
     * @param department tham số về bộ phận làm việc.
     * @param dayOff tham số về số ngày nghỉ.
     * @param overtimeHours tham số về số giờ làm thêm.
     */
    public Employee(int id, String name, int age, double factor, String startDate, String department,
                    int dayOff,int overtimeHours){
        setId(id);
        setName(name);
        setAge(age);
        setFactor(factor);
        setStartDate(startDate);
        setDepartment(department);
        setDayOff(dayOff);
        setOvertimeHours(overtimeHours);
    }

    public void setOvertimeHours(int overtimeHours){this.overtimeHours = overtimeHours;}
    public int getOvertimeHours(){return overtimeHours;}

    /**
     * Đây là phương thức calculateSalary() thực hiện của interface
     * dùng để tính tiền lương của nhân viên.
     * @return double, trả về tổng tiền lương kiểu double.
     */
    public double calculateSalary(){
        return getFactor()*3000000+overtimeHours*200000;
    }

    /**
     * Đây là phương thức displayInformation(), ghi đè của lớp Staff
     * dùng để in ra thông tin của nhân viên có bổ sung giờ làm thêm.
     */
    public void displayInformation(){
        System.out.println("ID Employee: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Factor: " + getFactor());
        System.out.println("Start Date: " + getStartDate());
        System.out.println("Department: " + getDepartment());
        System.out.println("Day off: " + getDayOff());
        System.out.println("Overtime Hours: " + getOvertimeHours());
        System.out.println("Salary: " +String.format("%.2f", calculateSalary()));
        //System.out.println("Salary: " + calculateSalary());
        System.out.println();
    }
}
