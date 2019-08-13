package interfaces;

import bank.BankAccounts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BankInterface {

    public List<BankAccounts> getAccountValue() throws IOException;

    public BankAccounts getAccount(String clientCardId) throws IOException;

      public void checkPin(String clientPin);

    public void setClient();

    public void getClient();

    String getName();




}
