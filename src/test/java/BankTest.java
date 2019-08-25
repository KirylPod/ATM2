import atm.machine.Atm;
import atm.money.AtmMoney;
import bank.Bank;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class BankTest extends BankDataProvider {

    @Test(priority = 1, dataProvider = "bank")
    public void getAccountCheck(String cardId, String pin, String cash) {
        Bank bank = new Bank();
        try {
            getLogger().info("Validate that accountId equals: " + cardId);
            Assert.assertEquals(bank.getAccount(cardId, null, null).getAccountId(), cardId);
            getLogger().info("Validate that pin equals: " + pin);
            Assert.assertEquals(bank.getAccount(cardId, null, null).getAccountPin(), pin);
            getLogger().info("Validate that cash equals: " + cash);
            Assert.assertEquals(bank.getAccount(cardId, null, null).getAccountCash(), cash);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
