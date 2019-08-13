package atm;

import bank.Bank;
import bank.BankAccounts;
import card.Card;
import interfaces.AtmInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
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
    private String money;
    private BankAccounts account;
    private AtmEvents events;
    private Bank bank = new Bank();
    private BufferedReader br;


    @Override
    public void validId(Card card) throws IOException {
        account = bank.getAccount(card.getClientId());
        if (account == null) {
            events.errorClientId();
        }
    }

    @Override
    public void inputPin(String clientPin) throws IOException {

        System.out.println("Введите пин-код, состоящий из цифр, в формате: ХХХХ");
        card.setClientPin(br.readLine());
        if (Pattern.matches("^\\d{4}", card.getClientPin()) && card.getClientPin().equals(clientPin)) {
            validId(card);
        } else {
            events.errorClientPin(clientPin);
        }
        br.close();
    }


    @Override
    public void validPin(Card card) throws IOException {
        if(card.getClientPin().equals(account.getAccountPin())){
            card.setClientPin(account.getAccountPin());
            operation();
        }else{

        }

    }

    @Override

    public String getMoney() throws IOException {
        cashMachineMoney.getCashMachineMoney();
        operation();

        return money;
    }

    @Override
    public String checkBalance() {

        account.setCardValue(cashMachineDriver.getValue(account.getAccountCash()));

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
