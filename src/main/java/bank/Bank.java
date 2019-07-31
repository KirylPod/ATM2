package bank;

import interfaces.AtmInterface;
import interfaces.BankInterface;
import interfaces.ClientInterface;

import java.io.IOException;
import java.util.ArrayList;

public class Bank extends AbstarctBank implements BankInterface {

    @Override
    public void checkId(String cardId) throws IOException {
        bankAccounts.getAccount(cardId);
    }

    @Override
    public void checkPin(String clientPin) {

    }

    @Override
    public void setClient() {

    }

    @Override
    public void getClient() {

    }

    @Override
    public String getName() {
        return null;
    }
}
