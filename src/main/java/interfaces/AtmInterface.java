package interfaces;

import atm.machine.AtmEvents;
import atm.money.AtmMoney;
import client.card.Card;

import java.io.IOException;

public interface AtmInterface {

    public void validId(Card card, AtmEvents events) throws IOException;

    public void inputPin(Card card, AtmEvents events) throws IOException;

    public void validPin(Card card, AtmEvents events) throws IOException;

    public void getAtmMoney() throws IOException;

    public void operation() throws IOException;

    public void yesNo() throws IOException;

    public String checkBalance(String value);

    public String getCash(String value) throws IOException;

    public String setCash(String value) throws IOException;

    public Integer stringToInt (String str);

}
