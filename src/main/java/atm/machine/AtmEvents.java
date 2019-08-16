package atm.machine;

import client.Client;
import client.card.Card;

import java.io.IOException;

public class AtmEvents {

    private Atm atm;
    private Client client;

    public AtmEvents(Atm atm, Client client) {
        this.atm = atm;
        this.client = client;
    }

    public void errorAccountId() throws IOException {
        System.out.println("Ваша карта не действительна");
        System.out.println("Обратитесь в банк в которым вы обслуживаетесь");
        client.takeCard();
    }

    public void errorClientPin(Card card) throws IOException {
        System.out.println("Введенный пин-код не соотвествует заданному формату");
        atm.inputPin(card);
    }

    public void errorAccountPin(Card card) throws IOException {
        System.out.println("Вы ввели не верный PIN");
        atm.validPin(card);
    }

    public void errorGetCashId() throws IOException {
        System.out.println("Недостаточно средств на счете");
        atm.yesNo();
    }

    public void errorGetCashMachine() throws IOException {
        System.out.println("Недостаточно средств в банкомате");
        atm.yesNo();
    }

    public void errorSetCashMachine() throws IOException {
        System.out.println("Сумма пополнения не должна превышать 1 000 000");
        atm.yesNo();
    }
    public void successCardId() throws IOException {
        System.out.println("Спасибо за то, что вы с нами. Удачного дня");
        System.out.println(" ");
        client.takeCard();

    }
    public void errorInputOperation() throws IOException {
        System.out.println("Данной операции не существует");
        atm.operation();
    }

    public void errorInputYesNo() throws IOException {
        System.out.println("Данной операции не существует");
        atm.yesNo();
    }
}
