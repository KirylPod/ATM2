package atm;

import interfaces.AtmInterface;
import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
@AllArgsConstructor

public abstract class AbstractAtm implements AtmInterface {

   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getCard(String cardId) {

        return cardId;
    }

    @Override
    public Boolean validId(String cardId) throws IOException {

        return true;
    }

    @Override
    public String inputPin(String clientPin) throws IOException {
        return null;
    }

    @Override
    public String inputCash() {
        return null;
    }

    @Override
    public String getCash() {
        return null;
    }

    @Override
    public String setCash() {
        return null;
    }


}
