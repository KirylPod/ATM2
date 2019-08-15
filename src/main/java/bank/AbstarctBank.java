package bank;

import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class AbstarctBank implements BankInterface {

    private List<BankAccounts> clientList = new ArrayList<BankAccounts>();
    private File file;

    @Override
    public List<BankAccounts> getAccountValue() throws IOException {
        file = new File("src/main/resources/accounts");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = "";
        String[] account = line.split(" ");
        while ((line = reader.readLine()) != null) {
            account = line.split(" ");
            clientList.add(new BankAccounts(account[0], account[1], account[2]));
        }
        reader.close();
        return clientList;
    }

    @Override
    public BankAccounts getAccount(String cardId) throws IOException {
        Optional<BankAccounts> account = getAccountValue()
                .stream().filter(c -> c.getAccountId().equals(cardId))
                .findFirst();
        if (account.isPresent()) {
            return account.get();
        } else {
            //          bankServerPrint.errorAccount();
            return null;
        }
    }




}