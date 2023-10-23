public interface IStudentBuilder {

     StudentBuilder setPhone(String phone);
     Student build();
     StudentBuilder setId(int id);
     StudentBuilder setGpa(double gpa);
     StudentBuilder setName(String name);
}
