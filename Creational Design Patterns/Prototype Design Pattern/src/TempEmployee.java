public class TempEmployee extends EmployeeProtoType{
    @Override
    public EmployeeProtoType shallowCopy() throws CloneNotSupportedException {
        return (TempEmployee) this.clone();
    }

    @Override
    public EmployeeProtoType DeepCopy() throws CloneNotSupportedException {
        TempEmployee emp=new TempEmployee();
        emp=(TempEmployee) this.clone();
        emp.name=this.name;
        emp.id=this.id;
        emp.address=new Address(
                this.address.cityName,
                this.address.streetName
        );
        return emp;
    }

    @Override
    public String toString() {
        return "TempEmployee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
