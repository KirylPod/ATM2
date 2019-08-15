package client;

import client.card.Card;
import interfaces.ClientInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

@Getter
@Setter

public abstract class AbstractClient implements ClientInterface {

    private String clientId;
    private Card card;

    @Override
    public void takeCard() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        clientId = br.readLine();
        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", clientId)) {
            card = new Card(clientId, "");

        } else {
            System.out.println("Введенный номер карты не соотвествует заданному формату");
            takeCard();
        }

     }

}
