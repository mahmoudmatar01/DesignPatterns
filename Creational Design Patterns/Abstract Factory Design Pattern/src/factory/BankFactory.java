package factory;

import models.*;

public class BankFactory implements IBankFactory{
    @Override
    public Bank getBank(String bankCode) {
        return switch (bankCode) {
            case "12345" -> new BanqueMisr();
            case "11111" -> new BanqueDuCairo();
            default -> null;
        };
    }

    @Override
    public Payment getPaymentCard(String cardNumber) {
        return switch (cardNumber.charAt(cardNumber.length()-1)) {
            case '1' -> new Visa();
            case '2' -> new MasterCard();
            default -> null;
        };
    }
}
