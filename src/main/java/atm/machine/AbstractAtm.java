package atm.machine;

import atm.money.AtmMoney;
import bank.Bank;
import bank.BankAccounts;
import client.Client;
import client.card.Card;
import enums.Menu;
import interfaces.AtmInterface;
import interfaces.Logging;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Getter
@Setter

public abstract class AbstractAtm implements AtmInterface, Logging {

    private AtmMoney atmMoney = new AtmMoney();
    private Bank bank = new Bank();
    private Client client = new Client();

    private BankAccounts account;
    private int cash;

    AtmEvents events = new AtmEvents((Atm) this, client);

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    protected AbstractAtm() {
    }

    public void go() throws IOException {

        validId(client.goToAtm((Atm) this, events), client.getCard(), events);
    }

    @Override
    public void validId(Client client, Card card, AtmEvents events) throws IOException {
        account = bank.getAccount(card.getCardId(), client, events);
        if (account != null) {
            inputPin(client, card, events);
        } else {
            events.errorAccountId(client, events);
        }
    }

    @Override
    public void inputPin(Client client, Card card, AtmEvents events) throws IOException {
        System.out.println("Введите Ваш пин-код, состоящий из цифр, в формате: ХХХХ");
        card.setCardPin(br.readLine());
        if (Pattern.matches("^\\d{4}", card.getCardPin())) {
            validPin(client, card, events);
        } else {
            events.errorClientPin(card, (Atm) this);
        }
    }

    @Override
    public void validPin(Client client, Card card, AtmEvents events) throws IOException {
        if (card.getCardPin().equals(account.getAccountPin())) {
            card.setCardPin(account.getAccountPin());
            getAtmMoney(client);
        } else {
            events.errorAccountPin(card, (Atm) this);
        }
    }

    @Override
    public void getAtmMoney(Client client) throws IOException {
        atmMoney.reedAtmMoney();
        operation(client, events);
    }

    @Override
    public void operation(Client client, AtmEvents events) throws IOException {

        getLogger().info(Menu.CHECK_BALANCE.getType());
        getLogger().info(Menu.GET_CASH.getType());
        getLogger().info(Menu.SET_CASH.getType());
        getLogger().info(Menu.RETURN_CARD.getType());

        String num = br.readLine();
        if (Pattern.matches("^[1-4]{1}", num)) {
            switch (num) {
                case "1":
                    account.setAccountCash(checkBalance(account.getAccountCash()));
                    yesNo(client, events);
                    break;
                case "2":
                    account.setAccountCash(getCash(account.getAccountCash()));
                    yesNo(client, events);
                    break;
                case "3":
                    account.setAccountCash(setCash(account.getAccountCash()));
                    yesNo(client, events);
                    break;
                case "4":
                    System.out.println("Заберите вашу карту");
                    bank.setAccount(account.getAccountId(), account.getAccountCash());
                    atmMoney.writeAtmMoney();
                    events.successCardId(client);
                    break;
            }
        } else {
            events.errorInputOperation((Atm) this, client);
        }
    }

    @Override
    public void yesNo(Client client, AtmEvents events) throws IOException {
        System.out.println("Желаете продолжить?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Отмена");
        String num = br.readLine();

        if (Pattern.matches("^[1-2]{1}", num)) {
            switch (num) {
                case "1":
                    operation(client, events);
                    break;
                case "2":
                    System.out.println("Заберите вашу карту");
                    bank.setAccount(account.getAccountId(), account.getAccountCash());
                    atmMoney.setMoney(atmMoney.getMoney());
                    atmMoney.writeAtmMoney();
                    events.successCardId(client);
                    break;
            }
        } else {
            events.errorInputYesNo((Atm) this, client);
        }
        br.close();
    }

    @Override
    public String checkBalance(String value) {
        System.out.println("На вашем счету = " + account.getAccountCash());
        return account.getAccountCash();
    }

    @Override
    public String getCash(String value) throws IOException {

        System.out.println("Введите сумму, которую желаете снять");
        cash = Integer.parseInt(br.readLine());

        if (cash > atmMoney.getMoney()) {
            events.errorGetCashId((Atm) this, client);
        }
        if (cash >= atmMoney.getMoney()) {
            events.errorGetCashMachine((Atm) this, client);
        }

        System.out.println("Операция выполнена успешно, заберите деньги: " + cash);

        atmMoney.setMoney(atmMoney.getMoney() - cash);

        return value = String.valueOf(stringToInt(account.getAccountCash()) - cash);

    }

    @Override
    public String setCash(String value) throws IOException {

        System.out.println("Введите сумму, на которую желаете пополнить счет");
        cash = Integer.parseInt(br.readLine());
        if (cash >= 1000000) {
            events.errorSetCashMachine((Atm) this, client);
        }

        System.out.println("Операция выполнена успешно, вы пополнили счет на: " + cash);

        atmMoney.setMoney(atmMoney.getMoney() + cash);

        return value = String.valueOf(stringToInt(account.getAccountCash()) + cash);
    }

    @Override
    public Integer stringToInt(String str) {
        return Integer.parseInt(str);
    }


}





