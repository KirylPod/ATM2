package interfaces;


import card.AbstractCard;
import card.Card;

public interface CardInterface {

    public Card createCard(String clientId);

    public Card insertCardToAtm(Card card);

}
