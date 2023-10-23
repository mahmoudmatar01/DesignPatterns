public class RegEmployee extends EmployeeProtoType{
    @Override
    public EmployeeProtoType shallowCopy() throws CloneNotSupportedException {
        return (RegEmployee) this.clone();
    }

    @Override
    public EmployeeProtoType DeepCopy() throws CloneNotSupportedException {
        RegEmployee emp=new RegEmployee();
        emp=(RegEmployee) this.clone();
        emp.name=this.name;
        emp.address=new Address(
                this.address.cityName,
                this.address.streetName
        );
        emp.id=this.id;
        return emp;
    }

    @Override
    public String toString() {
        return "RegEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}

