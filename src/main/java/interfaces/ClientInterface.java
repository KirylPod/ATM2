package interfaces;

import card.Card;
import client.Client;

import java.io.IOException;

public interface ClientInterface {


    public void enterClientId(String clientId) throws IOException;

    public void errorClientId(String clientId) throws IOException;

    public void inputCash();



    public void insertCardToAtm(Card card);
}
