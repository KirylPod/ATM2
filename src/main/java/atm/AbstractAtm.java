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
import java.io.InputStreamReader;
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
    private AbstractAtmMoney atmMoney;
    private AbstractAtmKeyboard keyboard;
    private BankAccounts account;
    private AtmEvents events;
    private Bank bank = new Bank();

    private int cash;

    private BufferedReader brAtm = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void validId(Card card) throws IOException {
        account = bank.getAccount(card.getClientId());
        inputPin(card);
        if (account == null) {
            events.errorClientId();
        }
    }

    @Override
    public void inputPin(Card card) throws IOException {

        System.out.println("Введите пин-код, состоящий из цифр, в формате: ХХХХ");


        card.setClientPin(brAtm.readLine());

        if (Pattern.matches("^\\d{4}", card.getClientPin())) {

            validPin(card);
        } else {
            events.errorClientPin(card.getClientPin());
        }
        brAtm.close();
    }

    @Override
    public void validPin(Card card) throws IOException {
        if (card.getClientPin().equals(account.getAccountPin())) {
            card.setClientPin(account.getAccountPin());
            getAtmMoney();
        } else {
            events.errorAccountPin(card.getClientPin());
        }
    }

    @Override

    public int getAtmMoney() throws IOException {

        atmMoney.reedAtmMoney();

        keyboard.operation();
        return atmMoney.getMoney();
    }

    @Override
    public String checkBalance() {
        System.out.println("На вашем счету = " + account.getAccountCash());
        return account.getAccountCash();
    }

    @Override
    public AbstractAtmMoney getCash(AbstractAtmMoney atmMoney) throws IOException {

        System.out.println("Введите сумму, которую желаете снять");
        cash = Integer.parseInt(brAtm.readLine());

        if (cash > atmMoney.getMoney()) {
            events.errorGetCashId();
        }
        if (cash >= atmMoney.getMoney()) {
            events.errorGetCashMachine();
        }

        System.out.println("Операция выполнена успешно, заберите деньги: " + cash);

        atmMoney.setMoney(atmMoney.getMoney() - cash);

        return atmMoney;

    }

    @Override
    public AbstractAtmMoney setCash(AbstractAtmMoney atmMoney) throws IOException {

        System.out.println("Введите сумму, на которую желаете пополнить счет");
        cash = Integer.parseInt(brAtm.readLine());
        if (cash >= 1000000) {
            events.errorSetCashMachine();
        }
        atmMoney.setMoney(atmMoney.getMoney() + cash);
        atmMoney.writeAtmMoney();

        System.out.println("Операция выполнена успешно, вы пополнили счет на: " + cash);

        return atmMoney;

    }

}
