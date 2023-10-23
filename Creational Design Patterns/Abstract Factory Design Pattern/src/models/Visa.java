package models;

public class Visa extends Payment{
    @Override
    public String getName() {
        return "Visa Card";
    }

    @Override
    public String getProviderInfo() {
        return "Visa Company";
    }
}
