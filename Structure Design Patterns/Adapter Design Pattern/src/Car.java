public class Car implements Vehicle{
    @Override
    public String accelerate() {
        return "car starts moving";
    }

    @Override
    public String pushBreaking() {
        return "car stopped";
    }

    @Override
    public String soundHorn() {
        return "Beep Beeb";
    }
}
