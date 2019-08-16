package bank;

import atm.machine.AtmEvents;
import interfaces.BankInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter

public abstract class AbstarctBank implements BankInterface {

    private List<BankAccounts> clientList = new ArrayList<BankAccounts>();
    private File file;
    private AtmEvents events;

    public AbstarctBank(AtmEvents events) {
        this.events = events;
    }

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
            events.errorAccountId();
            return null;
        }
    }

    @Override
    public void setAccount(String id, String newValue) throws IOException {
        clientList.stream().filter(c -> c.getAccountId().equals(id)).findFirst().get().setAccountCash(newValue);
        file = new File("src/main/resources/accounts");
        FileWriter writer = new FileWriter(file, false);
        for (int i = 0; i < clientList.size(); i++) {
            writer.write(clientList.get(i).getAccountId() + " " + clientList.get(i).getAccountPin() + " " + clientList.get(i).getAccountCash() + "\n");
        }
        clientList.clear();
        writer.close();
    }


}