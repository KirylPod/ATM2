package atm.machine;

import atm.money.AtmMoney;
import bank.Bank;
import bank.BankAccounts;
import client.card.Card;
import interfaces.AtmInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Getter
@Setter

public abstract class AbstractAtm implements AtmInterface {

    private AtmMoney atmMoney = new AtmMoney();
    private AtmEvents events = new AtmEvents();
    private Bank bank = new Bank();


    private BankAccounts account;
    private int cash;


    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void validId(Card card) throws IOException {
        account = bank.getAccount(card.getCardId());
        inputPin(card);
        if (account == null) {
            events.errorAccountId();
        }
    }

    @Override
    public void inputPin(Card card) throws IOException {
        System.out.println("Введите Ваш пин-код, состоящий из цифр, в формате: ХХХХ");
        card.setCardPin(br.readLine());
        if (Pattern.matches("^\\d{4}", card.getCardPin())) {
            validPin(card);
        } else {
            events.errorClientPin(card);
        }
    }

    @Override
    public void validPin(Card card) throws IOException {
        if (card.getCardPin().equals(account.getAccountPin())) {
            card.setCardPin(account.getAccountPin());
            getAtmMoney();
        } else {
            events.errorAccountPin(card.getCardPin());
        }
    }

    @Override
    public void getAtmMoney() throws IOException {
        atmMoney.reedAtmMoney();
        operation();
    }

    @Override
    public void operation() throws IOException {

        System.out.println("1 - Проверить баланс");
        System.out.println("2 - Снять наличные");
        System.out.println("3 - Пополнить баланс");
        System.out.println("4 - Вернуть карту");

        String num = br.readLine();
        if (Pattern.matches("^[1-4]{1}", num)) {
            switch (num) {
                case "1":
                    account.setAccountCash(checkBalance(account.getAccountCash()));
                    yesNo();
                    break;
                case "2":
                    account.setAccountCash(getCash(account.getAccountCash()));
                    yesNo();
                    break;
                case "3":
                    account.setAccountCash(setCash(account.getAccountCash()));
                    yesNo();
                    break;
                case "4":
                    System.out.println("Заберите вашу карту");
                    bank.setAccount(account.getAccountId(), account.getAccountCash());
                    atmMoney.writeAtmMoney();
                    events.successCardId();
                    break;
            }
        } else {
            events.errorInputOperation();
        }
    }

    @Override
    public void yesNo() throws IOException {
        System.out.println("Желаете продолжить?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Отмена");
        String num = br.readLine();

        if (Pattern.matches("^[1-2]{1}", num)) {
            switch (num) {
                case "1":
                    operation();
                    break;
                case "2":
                    System.out.println("Заберите вашу карту");
                    bank.setAccount(account.getAccountId(), account.getAccountCash());
                    atmMoney.setMoney(atmMoney.getMoney());
                    atmMoney.writeAtmMoney();
                    events.successCardId();
                    break;
            }
        } else {
            events.errorInputYesNo();
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
            events.errorGetCashId();
        }
        if (cash >= atmMoney.getMoney()) {
            events.errorGetCashMachine();
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
            events.errorSetCashMachine();
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





