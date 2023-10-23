package models;

public class MasterCard extends Payment{
    @Override
    public String getName() {
        return "MasterCard";
    }

    @Override
    public String getProviderInfo() {
        return "MasterCard Company";
    }
}
