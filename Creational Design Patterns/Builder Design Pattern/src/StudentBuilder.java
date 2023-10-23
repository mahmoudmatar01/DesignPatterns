public class StudentBuilder {

    private  String studentName;
    private  double gpa;
    private int id;
    private  String phone;

    public StudentBuilder id(int id){
        this.id=id;
        return this;
    }
    public StudentBuilder gpa(double gpa){
        this.gpa=gpa;
        return this;
    }
    public StudentBuilder name(String name){
        this.studentName=name;
        return this;
    }
    public StudentBuilder phone(String phone){
        this.phone=phone;
        return this;
    }

    //builder method
    public Student build(){
        return new Student(
                studentName,gpa,id,phone
        );
    }

}
