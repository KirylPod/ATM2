package card;

import interfaces.CardInterface;

public class Card extends AbstractCard implements CardInterface {

    public Card(String clientId) {
        super(clientId);
    }

    @Override
    public Card createCard(String clientId) {
        return null;
    }

    @Override
    public Card insertCardToAtm(Card card) {
        return null;
    }
}
