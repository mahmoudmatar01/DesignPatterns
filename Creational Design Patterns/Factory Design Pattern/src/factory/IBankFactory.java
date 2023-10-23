package factory;

import models.Bank;

public interface IBankFactory {
     Bank getBank(String bankCode);
}
