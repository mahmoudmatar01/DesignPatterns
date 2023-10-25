public class BicycleAdapter implements Vehicle{

    private final Bicycle bicycle;

    public BicycleAdapter(Bicycle bicycle) {
        this.bicycle = bicycle;
    }

    @Override
    public String accelerate() {
        return bicycle.pedal();
    }

    @Override
    public String pushBreaking() {
        return bicycle.stop();
    }

    @Override
    public String soundHorn() {
        return bicycle.ringBell();
    }
}
