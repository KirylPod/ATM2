package client;

import card.Card;
import interfaces.ClientInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractClient implements ClientInterface {

    private String clientId;

    Card card = new Card();

    private int cash;
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String enterClientId() throws IOException {

        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        setClientId(br.readLine());

        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", getClientId())) {
            card.setCardId(getClientId());

        } else {
            errorClientId();
        }
        br.close();

        return clientId;

    }

    @Override
    public void errorClientId() throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
        enterClientId();
    }
}
