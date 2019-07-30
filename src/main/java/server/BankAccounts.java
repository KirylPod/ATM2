package server;

import interfaces.ServerInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccounts implements ServerInterface {

    private String cardId, cardPin, cardCash;

    public BankAccounts(String cardId, String cardPin, String cardCash) {
        this.cardId = cardId;
        this.cardPin = cardPin;
        this.cardCash = cardCash;
    }

    private static List<BankAccounts> clientList;
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

    public BankAccounts getAccount(String clientCardId) throws IOException {
        Optional<BankAccounts> account = getAccountValue()
                .stream().filter(c -> c.getCardId().equals(clientCardId))
                .findFirst();
        if (account.isPresent()) {
            return account.get();
        } else {
  //          bankServerPrint.errorAccount();
            return null;
        }
    }
}
