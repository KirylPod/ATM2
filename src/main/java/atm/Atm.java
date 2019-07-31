package atm;

import card.Card;
import interfaces.AtmInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class Atm extends AbstractAtm implements AtmInterface {

    @Override
    public void getCard(Card card) {

    }

    @Override
    public Boolean validId(String cardId) throws IOException {
        return null;
    }

    @Override
    public String inputPin(String clientPin) throws IOException {
        return null;
    }

    @Override
    public String inputCash() {
        return null;
    }

    @Override
    public String getCash() {
        return null;
    }

    @Override
    public String setCash() {
        return null;
    }
}
