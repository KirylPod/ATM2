package card;

import interfaces.CardInterface;

import java.io.IOException;

public class Card extends AbstractCard {

    public Card() {
        super();
    }

    public Card(String clientId, String clientPin) {
        super(clientId, clientPin);
    }
}
