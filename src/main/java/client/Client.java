package client;

import card.Card;
import interfaces.ClientInterface;

import java.io.IOException;
import java.util.regex.Pattern;

public class Client extends AbstractClient implements ClientInterface {

    @Override
    public void enterClientId(String clientId) throws IOException {
        System.out.println("Введите номер карты, состоящий из цифр, в формате: ХХХХ-ХХХХ-ХХХХ-ХХХХ");
        clientId = getBr().readLine();
        if (Pattern.matches("^\\d{4}-\\d{4}-\\d{4}-\\d{4}$", clientId)) {
        } else {
            errorClientId(clientId);
        }
        getBr().close();
    }

    @Override
    public void errorClientId(String clientId) throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
        enterClientId(clientId);
    }


    @Override
    public void inputCash() {

    }

    @Override
    public void insertCardToAtm(Card card) {

    }
}
