package bank;

import atm.machine.AtmEvents;
import client.Client;

import java.io.IOException;
import java.util.List;

public class Bank extends AbstarctBank {


    @Override
    public List<BankAccounts> getAccountValue() throws IOException {
        return super.getAccountValue();
    }

    @Override
    public BankAccounts getAccount(String cardId, Client client) throws IOException {
        return super.getAccount(cardId, client);
    }

    @Override
    public void setAccount(String id, String newValue) throws IOException {
        super.setAccount(id, newValue);
    }
}
