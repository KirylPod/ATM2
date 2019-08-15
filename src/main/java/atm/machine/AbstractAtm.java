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
    private int value;

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public void validId(Card card) throws IOException {
        account = bank.getAccount(card.getCardId());
        inputPin(card);
        if (account == null) {
            events.errorClientId();
        }

    }

    @Override
    public void inputPin(Card card) throws IOException {
        System.out.println("Введите Ваш пин-код, состоящий из цифр, в формате: ХХХХ");
        card.setCardPin(br.readLine());
        if (Pattern.matches("^\\d{4}", card.getCardPin())) {
            validPin(card);
        } else {
            events.errorClientPin(card.getCardPin());
        }
        br.close();
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
    public int getAtmMoney() throws IOException {
        value = atmMoney.reedAtmMoney();
        operation();
        return value;
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
                    checkBalance();
//                    account.setCardValue(cashMachineDriver.getValue(account.getCardValue()));
                    yesNo();
                    break;
                case "2":
//                    account.setCardValue(cashMachineDriver.getCash(account.getCardValue()));
                    yesNo();
                    break;
                case "3":
//                    account.setCardValue(cashMachineDriver.setValue(account.getCardValue()));
                    yesNo();
                    break;
                case "4":
                    System.out.println("Заберите вашу карту");
//                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
//                    cashMachineMoney.setCashMachineMoney();
//                    cashMashinePrint.successCardId();
                    break;
            }

        } else {
            events.errorInputOperation();

        }
        br.close();
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
//                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
//                    cashMachineMoney.setCashMachineMoney();
//                    cashMashinePrint.successCardId();
                    break;
            }
        } else {
            events.errorInputYesNo();
        }
        br.close();

    }

    @Override
    public String checkBalance() {
        System.out.println("На вашем счету = " + account.getAccountCash());
        return account.getAccountCash();

    }

    @Override
    public AtmMoney getCash(AtmMoney atmMoney) throws IOException {

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
        br.close();
        return atmMoney;

    }


    @Override
    public AtmMoney setCash(AtmMoney atmMoney) throws IOException {

        System.out.println("Введите сумму, на которую желаете пополнить счет");
        cash = Integer.parseInt(br.readLine());
        if (cash >= 1000000) {
            events.errorSetCashMachine();
        }
        atmMoney.setMoney(atmMoney.getMoney() + cash);
        atmMoney.writeAtmMoney();

        System.out.println("Операция выполнена успешно, вы пополнили счет на: " + cash);
        br.close();
        return atmMoney;

    }
}





