import basic_sandwich.BasicSandwich;
import basic_sandwich.Sandwich;
import sandwichs_type.CheeseSandwich;
import sandwichs_type.MeetSandwich;

public class Main {
    public static void main(String[] args) {

        Sandwich meetSandwich=new MeetSandwich(new BasicSandwich());
        Sandwich cheeseSandwich=new CheeseSandwich(new BasicSandwich());
        Sandwich basicSandwich=new BasicSandwich();

        System.out.println("=========== Basic sandwich info ==================");
        System.out.println(basicSandwich.getDescription());
        System.out.println(basicSandwich.getCost());

        System.out.println("=========== Meet sandwich info ==================");
        System.out.println(meetSandwich.getDescription());
        System.out.println(meetSandwich.getCost());

        System.out.println("=========== Cheese sandwich info ==================");
        System.out.println(cheeseSandwich.getDescription());
        System.out.println(cheeseSandwich.getCost());

        }
}