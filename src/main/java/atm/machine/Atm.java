package atm.machine;

import client.Client;
import client.card.Card;

import java.io.IOException;

public class Atm extends AbstractAtm {

    @Override
    public void validId(Client client, Card card, AtmEvents events) throws IOException {
        super.validId(client, card, events);
    }

    @Override
    public void inputPin(Client client, Card card, AtmEvents events) throws IOException {
        super.inputPin(client, card, events);
    }

    @Override
    public void validPin(Client client, Card card, AtmEvents events) throws IOException {
        super.validPin(client, card, events);
    }

    @Override
    public void getAtmMoney(Client client) throws IOException {
        super.getAtmMoney(client);
    }

    @Override
    public void operation(Client client) throws IOException {
        super.operation(client);
    }

    @Override
    public void yesNo(Client client) throws IOException {
        super.yesNo(client);
    }

    @Override
    public String checkBalance(String value) {
        return super.checkBalance(value);
    }

    @Override
    public String getCash(String value) throws IOException {
        return super.getCash(value);
    }

    @Override
    public String setCash(String value) throws IOException {
        return super.setCash(value);
    }

    @Override
    public Integer stringToInt(String str) {
        return super.stringToInt(str);
    }
}





