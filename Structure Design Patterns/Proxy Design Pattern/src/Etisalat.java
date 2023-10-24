public class Etisalat implements InternetServices {

    private int browsingSpeed=10;

    @Override
    public String serviceSite(String url) {
        return String.format("https://%s.com",url);
    }

    public int getBrowsingSpeed() {
        return browsingSpeed;
    }

    public void setBrowsingSpeed(int browsingSpeed) {
        this.browsingSpeed = browsingSpeed;
    }
}
