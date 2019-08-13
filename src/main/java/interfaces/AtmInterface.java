package interfaces;

import card.Card;

import java.io.IOException;

public interface AtmInterface {

    public void validId(Card card) throws IOException;

    public void inputPin(String clientPin) throws IOException;

    public void validPin(Card card) throws IOException;

    public String getMoney() throws IOException;

    public String checkBalance();

    public String inputCash();

    public String getCash();

    public String setCash();

}
