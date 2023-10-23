
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Prototype Design Pattern :- Specify the kinds of objects to create using a prototypical instance ,
        // and create new objects by copying this prototype
        // 0r
        // Copy heavy initialization objects instead of creating it


        EmployeeProtoType tempEmployee=new TempEmployee();
        tempEmployee.name="mahmoud";
        tempEmployee.id=1;
        tempEmployee.address=new Address("Tanta","Nefia");

        EmployeeProtoType tempEmployee2=tempEmployee.shallowCopy();
        EmployeeProtoType tempEmployee3=tempEmployee.DeepCopy();
        System.out.println("Temp 1 Original");
        System.out.println(tempEmployee.toString());
        System.out.println("Temp 2 Copy");
        System.out.println(tempEmployee2.toString());

        System.out.println("==========================");

        tempEmployee2.address.streetName="new Street";
        System.out.println("Temp 1 Original");
        System.out.println(tempEmployee.toString());
        System.out.println("Temp 2 Copy");
        System.out.println(tempEmployee2.toString());
        System.out.println("Temp 3 Deep Copy");
        System.out.println(tempEmployee3.toString());



    }
}

