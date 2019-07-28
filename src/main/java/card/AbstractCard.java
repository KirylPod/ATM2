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

    @Override
    public void insertCardToAtm(String clientId) {
        atm.getCard(clientId);
            }
}
