package bank;

import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Getter
@Setter

public class BankAccounts {

    private String accountId, accountPin, accountCash;


    public BankAccounts() {
    }
    public BankAccounts(String accountId, String accountPin, String accountCash) {
        this.accountId = accountId;
        this.accountPin = accountPin;
        this.accountCash = accountCash;
    }

}
