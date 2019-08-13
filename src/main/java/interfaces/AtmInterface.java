package interfaces;

import card.Card;

import java.io.IOException;

public interface AtmInterface {

    public void validId(Card card) throws IOException;

    public String inputPin(String clientPin) throws IOException;

    public String inputCash();

    public String getCash();

    public String setCash();



}
