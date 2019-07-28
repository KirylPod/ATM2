package interfaces;

import server.BankAccounts;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface ServerInterface {
    public List<BankAccounts> getAccountValue() throws IOException;
}
