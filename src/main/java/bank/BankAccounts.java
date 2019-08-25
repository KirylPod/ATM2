package bank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BankAccounts {

    private String accountId, accountPin, accountCash;

//    public BankAccounts(String accountId, String accountPin, String accountCash) {
//        this.accountId = accountId;
//        this.accountPin = accountPin;
//        this.accountCash = accountCash;
//    }

}
