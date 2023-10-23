package factory;

import models.Bank;
import models.Payment;

public interface IBankFactory {
     Bank getBank(String bankCode);

     Payment getPaymentCard(String cardNumber);
}
