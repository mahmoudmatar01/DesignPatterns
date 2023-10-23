public class StudentBuilder implements IStudentBuilder {

    private  String studentName;
    private  double gpa;
    private int id;
    private  String phone;


    @Override
    public StudentBuilder setPhone(String phone) {
        this.phone=phone;
        return this;
    }

    @Override
    public Student build() {
        return new Student(
                studentName,gpa,id,phone
        );
    }

    //builder method

    @Override
    public StudentBuilder setId(int id) {
        this.id=id;
        return this;
    }

    @Override
    public StudentBuilder setGpa(double gpa) {
        this.gpa=gpa;
        return this;
    }

    @Override
    public StudentBuilder setName(String name) {
        this.studentName=name;
        return this;
    }

}
