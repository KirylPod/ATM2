package bank;

import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public abstract class AbstarctBank implements BankInterface {

    private String cardId, cardPin, cardCash;

    private String attempts;

    @Override
    public void checkId(String clientId) {

    }

    @Override
    public void checkPin(String clientPin) {

    }

    @Override
    public void setClient() {

    }

    @Override
    public void getClient() {

    }

    @Override
    public String getName() {
        return null;
    }
}
