package interfaces;

import atm.money.AtmMoney;
import client.card.Card;

import java.io.IOException;

public interface AtmInterface {

    public void validId(Card card) throws IOException;

    public void inputPin(Card card) throws IOException;

    public void validPin(Card card) throws IOException;

    public int getAtmMoney() throws IOException;

    public void operation() throws IOException;

    public void yesNo() throws IOException;

    public String checkBalance();

    public AtmMoney getCash(AtmMoney atmMoney) throws IOException;

    public AtmMoney setCash(AtmMoney atmMoney) throws IOException;


}
