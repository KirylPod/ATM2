package interfaces;

import atm.Atm;
import card.Card;

import java.io.IOException;

public interface CardInterface {

    public String createCard() throws IOException;

    public void errorClientId() throws IOException;

}
