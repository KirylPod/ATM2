package card;

import interfaces.BankInterface;
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

    private String cardId;

    private String cardPin;

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }


}
