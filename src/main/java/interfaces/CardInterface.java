package interfaces;


import card.Card;
import client.Client;

import java.io.IOException;

public interface CardInterface {

    public Card createCard(String clientId) throws IOException;


}
