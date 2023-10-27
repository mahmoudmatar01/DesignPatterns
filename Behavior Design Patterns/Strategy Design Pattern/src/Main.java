 public class Main {
    public static void main(String[] args) {

        var belya =new Mechanic();
        System.out.println("Toyota Car Entered Garage ");
        belya.setCarAlgorithm(new Toyota());
        belya.disassembleCar();

        System.out.println("=========after 5 min======================");

        System.out.println("Chev Car Entered Garage");
        belya.setCarAlgorithm(new Chevorlet());
        belya.disassembleCar();

        // Programming Scenario
        //       - Games
        //       - Sorting

    }
}