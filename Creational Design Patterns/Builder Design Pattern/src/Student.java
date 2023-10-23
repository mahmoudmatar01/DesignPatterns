public class Student {
    // normal class attributes
    private  String studentName;
    private  double gpa;
    private int id;
    private  String phone;

    public String getStudentName() {
        return studentName;
    }

    public double getGpa() {
        return gpa;
    }

    public int getId() {
        return id;
    }

    public String getPhone() {
        return phone;
    }

    public Student(String studentName, double gpa, int id, String phone) {
        this.studentName = studentName;
        this.gpa = gpa;
        this.id = id;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", gpa=" + gpa +
                ", id=" + id +
                ", phone='" + phone + '\'' +
                '}';
    }

    //builder Method
    public static StudentBuilder builder(){
        return new StudentBuilder();
    }
}
