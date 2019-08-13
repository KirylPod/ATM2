package atm;

import bank.Bank;
import card.Card;
import interfaces.AtmInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import bank.BankAccounts;

import java.io.IOException;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor

public abstract class AbstractAtm implements AtmInterface {

    public AbstractAtm(Card card) {
        this.card = card;
    }

    public AbstractAtm() {
    }

    private Card card;
    private BankAccounts account;
    private Bank bank = new Bank();

    @Override
    public void validId(Card card) throws IOException {

        bank.getAccount(card.getClientId());
    }

    @Override
    public String inputPin(String clientPin) throws IOException {
        return null;
    }

    @Override
    public String inputCash() {
        return null;
    }

    @Override
    public String getCash() {
        return null;
    }

    @Override
    public String setCash() {
        return null;
    }
}
