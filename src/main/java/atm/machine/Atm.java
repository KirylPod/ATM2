package atm.machine;

import client.card.Card;

import java.io.IOException;

public class Atm extends AbstractAtm {

    @Override
    public void validId(Card card, AtmEvents events) throws IOException {
        super.validId(card, events);
    }

    @Override
    public void inputPin(Card card, AtmEvents events) throws IOException {
        super.inputPin(card, events);
    }

    @Override
    public void validPin(Card card, AtmEvents events) throws IOException {
        super.validPin(card, events);
    }

    @Override
    public void getAtmMoney() throws IOException {
        super.getAtmMoney();
    }

    @Override
    public void operation() throws IOException {
        super.operation();
    }

    @Override
    public void yesNo() throws IOException {
        super.yesNo();
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





