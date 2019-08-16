package atm.machine;


import client.Client;
import client.card.Card;
import interfaces.AtmEventsInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter
public class AtmEvents implements AtmEventsInterface {

    private Atm atm;
    private Client client;


    public AtmEvents(Atm atm, Client client) {
        this.atm = atm;
        this.client = client;
    }

    @Override
    public void errorAccountId(Client client) throws IOException {
        System.out.println("Ваша карта не действительна");
        System.out.println("Обратитесь в банк, в которым вы обслуживаетесь");
        client.takeCard();
    }

    @Override
    public void errorClientPin(Card card, Atm atm) throws IOException {
        System.out.println("Введенный пин-код не соотвествует заданному формату");
        atm.inputPin(card, this);
    }

    @Override
    public void errorAccountPin(Card card, Atm atm) throws IOException {
        System.out.println("Вы ввели не верный PIN");
        atm.validPin(card, this);
    }

    @Override
    public void errorGetCashId(Atm atm) throws IOException {
        System.out.println("Недостаточно средств на счете");
        atm.yesNo();
    }

    @Override
    public void errorGetCashMachine(Atm atm) throws IOException {
        System.out.println("Недостаточно средств в банкомате");
        atm.yesNo();
    }

    @Override
    public void errorSetCashMachine(Atm atm) throws IOException {
        System.out.println("Сумма пополнения не должна превышать 1 000 000");
        atm.yesNo();
    }

    @Override
    public void successCardId(Client client) throws IOException {
        System.out.println("Спасибо за то, что вы с нами. Удачного дня");
        System.out.println(" ");
        client.takeCard();

    }

    @Override
    public void errorInputOperation(Atm atm) throws IOException {
        System.out.println("Данной операции не существует");
        atm.operation();
    }

    public void errorInputYesNo(Atm atm) throws IOException {
        System.out.println("Данной операции не существует");
        atm.yesNo();
    }
}
