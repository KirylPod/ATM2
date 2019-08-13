package card;

import atm.Atm;
import interfaces.CardInterface;
import lombok.AllArgsConstructor;
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

    @Override
    public String createCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        clientId = br.readLine();
        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", clientId)) {
            return clientId;

            } else {
            errorClientId();
        }
        br.close();
        return clientId;
    }

    @Override
    public void errorClientId() throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
        createCard();
    }
}









