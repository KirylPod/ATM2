package bank;

import atm.machine.AtmEvents;

import java.io.IOException;
import java.util.List;

public class Bank extends AbstarctBank {

    public Bank(AtmEvents events) {
        super(events);
    }

    @Override
    public List<BankAccounts> getAccountValue() throws IOException {
        return super.getAccountValue();
    }

    @Override
    public BankAccounts getAccount(String cardId) throws IOException {
        return super.getAccount(cardId);
    }

    @Override
    public void setAccount(String id, String newValue) throws IOException {
        super.setAccount(id, newValue);
    }
}
