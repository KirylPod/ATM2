package client;

import atm.Atm;
import card.Card;
import interfaces.ClientInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;

@Getter
@Setter

public abstract class AbstractClient implements ClientInterface {

    public AbstractClient(Card card) {
        this.card = card;
    }

    public AbstractClient() {
    }

    private Card card;

    @Override
    public void goToAtm() throws IOException {
        takeCard();
    }

    @Override
    public void takeCard() throws IOException {
        card.createCard();
        insertCardToAtm(card);
    }

    @Override
    public void insertCardToAtm(Card card) throws IOException {
        Atm atm = new Atm(card);
        atm.validId(card);

    }
}
