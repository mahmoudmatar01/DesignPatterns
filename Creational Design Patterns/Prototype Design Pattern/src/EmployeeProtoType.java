public abstract  class EmployeeProtoType implements Cloneable{

    public int id;
    public String name;
    public Address address;


    public abstract EmployeeProtoType shallowCopy() throws CloneNotSupportedException;
    public abstract EmployeeProtoType DeepCopy() throws CloneNotSupportedException;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
    @Override
    public String toString() {
        return "EmployeeProtoType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
