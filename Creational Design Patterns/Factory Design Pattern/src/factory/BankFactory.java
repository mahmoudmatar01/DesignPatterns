package factory;

import models.Bank;
import models.BanqueDuCairo;
import models.BanqueMisr;

public class BankFactory implements IBankFactory{
    @Override
    public Bank getBank(String bankCode) {
        return switch (bankCode) {
            case "12345" -> new BanqueMisr();
            case "11111" -> new BanqueDuCairo();
            default -> null;
        };
    }
}
