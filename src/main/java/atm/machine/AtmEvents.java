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
    public void errorAccountId(Client client, AtmEvents events) throws IOException {
        System.out.println("Ваша карта не действительна");
        System.out.println("Обратитесь в банк, в которым вы обслуживаетесь");
        atm.go();
    }

    @Override
    public void errorClientPin(Card card, Atm atm) throws IOException {
        System.out.println("Введенный пин-код не соотвествует заданному формату");
        atm.inputPin(client, card, this);
    }

    @Override
    public void errorAccountPin(Card card, Atm atm) throws IOException {
        System.out.println("Вы ввели не верный PIN");
        atm.validPin(client, card, this);
    }

    @Override
    public void errorGetCashId(Atm atm, Client client) throws IOException {
        System.out.println("Недостаточно средств на счете");
        atm.yesNo(client, this);
    }

    @Override
    public void errorGetCashMachine(Atm atm, Client client) throws IOException {
        System.out.println("Недостаточно средств в банкомате");
        atm.yesNo(client, this);
    }

    @Override
    public void errorSetCashMachine(Atm atm, Client client) throws IOException {
        System.out.println("Сумма пополнения не должна превышать 1 000 000");
        atm.yesNo(client, this);
    }

    @Override
    public void successCardId(Client client) throws IOException {
        System.out.println("Спасибо за то, что вы с нами. Удачного дня");
        System.out.println(" ");
        atm.go();
    }

    @Override
    public void errorInputOperation(Atm atm, Client client) throws IOException {
        System.out.println("Данной операции не существует");
        atm.operation(client, this);
    }

    @Override
    public void errorInputYesNo(Atm atm, Client client) throws IOException {
        System.out.println("Данной операции не существует");
        atm.yesNo(client, this);
    }


}
