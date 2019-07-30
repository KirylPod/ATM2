package bank;

import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import server.BankAccounts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class AbstarctBank implements BankInterface {

    private String attempts;
    private List<BankAccounts> clientList = new ArrayList<BankAccounts>();
public BankAccounts bankAccounts;
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
