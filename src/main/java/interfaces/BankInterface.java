package interfaces;

import bank.BankAccounts;
import client.Client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface BankInterface {

    public List<BankAccounts> getAccountValue() throws IOException;

    public BankAccounts getAccount(String clientCardId, Client client) throws IOException;

    public void setAccount(String id, String newValue) throws IOException;

}
