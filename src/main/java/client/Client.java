package client;

import card.Card;
import interfaces.ClientInterface;

import java.io.IOException;
import java.util.regex.Pattern;

public class Client extends AbstractClient implements ClientInterface {

    public Client(Card card) {
        super(card);
    }

    @Override
    public void enterClientId() throws IOException {
        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        setClientId(getBr().readLine());

        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", getClientId())) {
            getCard().createCard(getClientId());
        } else {
            errorClientId();
        }
        getBr().close();
    }

    @Override
    public void errorClientId() throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
        enterClientId();
    }
}
