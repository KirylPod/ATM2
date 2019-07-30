package card;

import atm.Atm;
import interfaces.CardInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class AbstractCard implements CardInterface {

    Atm atm = new Atm();

    private String cardId;

    public AbstractCard(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public void insertCardToAtm(String cardIdId) {
        atm.getCard(cardIdId);
            }
}
