/**
 * Đây là lớp Staff, là lớp trừu tượng
 * chứa các thông tin chung của các loại nhân viên.
 * Gồm id, name, age, factor, startDate, department, dayOff
 * cùng với getter và setter. Hơn nữa, có phương thức trừu tượng
 * displayInformation().
 */
abstract class Staff {
    private int id;
    private String name;
    private int age;
    private double factor;
    private String startDate;
    private String department;
    private int dayOff;

    public double getFactor(){return factor;}
    public int getId(){return id;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getStartDate(){return startDate;}
    public String getDepartment(){return department;}
    public int getDayOff(){return dayOff;}

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setAge(int age){this.age = age;}
    public void setFactor(double factor){this.factor = factor;}
    public void setStartDate(String startDate){this.startDate = startDate;}
    public void setDepartment(String department){this.department = department;}
    public void setDayOff(int dayOff){this.dayOff = dayOff;}

    /**
     *Đây là phương thức trừu tượng displayInformation(),
     * dùng để in ra thông tin của nhân viên.
     */
    public abstract void displayInformation();
}
