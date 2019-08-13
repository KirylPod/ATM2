package card;

import atm.AtmEvents;
import interfaces.CardInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Getter
@Setter
public abstract class AbstractCard implements CardInterface {

    public AbstractCard() {
    }

    public AbstractCard(String clientId, String clientPin) {
        this.clientId = clientId;
        this.clientPin = clientPin;
    }

    private String clientId, clientPin;
    private AtmEvents error;

    @Override
    public String createCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        clientId = br.readLine();
        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", clientId)) {
            return clientId;

            } else {
            error.errorClientId();
        }
        br.close();
        return clientId;
    }



}









