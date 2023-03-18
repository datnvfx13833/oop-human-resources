/**
 * Đây là lớp Department, chứa thông tin của các phòng ban,
 * gồm id, name, numberStaff cùng với các getter và setter.
 * Và phương thức để hiển thị thông tin phòng ban.
 */
public class Department {
    private int id;
    private String name;
    private int numberStaff;

    /**
     * Đây là constructor của lớp Department
     * @param id là tham số về mã của phòng ban.
     * @param name là tham số về tên phòng ban.
     * @param numberStaff là tham số về số lượng nhân viên của phòng ban.
     */
    public Department(int id,String name, int numberStaff){
        this.id = id;
        this.name = name;
        this.numberStaff = numberStaff;
    }

    public void setId(int id){this.id = id;}
    public void setName(String name){this.name = name;}
    public void setNumberStaff(int numberStaff){this.numberStaff = numberStaff;}

    public int getId(){return id;}
    public String getName(){return name;}
    public int getNumberStaff(){return numberStaff;}

    /**
     * Đây là phương thức toString() dùng để in ra thông tin của phòng ban.
     * @return String, do phương thức này là ghi đè nên vẫn giữ kiểu trả về.
     */
    public String toString(){
        System.out.println("Id Department: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Number of staff: " + getNumberStaff());
        System.out.println();
        return "";
    }
}
