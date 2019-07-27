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

    private BankInterface bank;

    private String cardId;

    private String cardPin;

    private String attempts;

}
