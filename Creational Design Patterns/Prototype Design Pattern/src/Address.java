public class Address {
   public String cityName;
   public String streetName;

    public Address(String cityName,String streetName) {
        this.cityName = cityName;
        this.streetName=streetName;
    }

    @Override
    public String toString() {
        return "Address{" +
                "cityName='" + cityName + '\'' +
                ", streetName='" + streetName + '\'' +
                '}';
    }
}
