public class Main {
    public static void main(String[] args) {

        Vehicle car=new Car();
        vehicleStartWork(car);

        System.out.println("====================================");
        // lets make bicycle object
        Vehicle bicycle=new BicycleAdapter(new Bicycle());
        vehicleStartWork(bicycle);
    }

    private static void vehicleStartWork(Vehicle vehicle) {
        System.out.println(vehicle.accelerate());
        System.out.println(vehicle.pushBreaking());
        System.out.println(vehicle.soundHorn());
    }
}