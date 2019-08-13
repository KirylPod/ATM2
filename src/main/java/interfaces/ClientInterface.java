package interfaces;

import card.Card;


import java.io.IOException;

public interface ClientInterface {

    public void goToAtm() throws IOException;

    public void takeCard() throws IOException;

    public void insertCardToAtm(Card card) throws IOException;

}
