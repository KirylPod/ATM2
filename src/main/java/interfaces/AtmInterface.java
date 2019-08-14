package interfaces;

import atm.AbstractAtmMoney;
import card.Card;

import java.io.IOException;

public interface AtmInterface {

    public void validId(Card card) throws IOException;

    public void inputPin(Card card) throws IOException;

    public void validPin(Card card) throws IOException;

    public int getAtmMoney() throws IOException;

    public String checkBalance();

    public AbstractAtmMoney getCash(AbstractAtmMoney atmMoney) throws IOException;

    public AbstractAtmMoney setCash(AbstractAtmMoney atmMoney) throws IOException;

}
