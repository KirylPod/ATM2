import card.Card;
import client.Client;

import java.io.IOException;

public class Start {
    public static void main(String[] args) throws IOException {

        Client client = new Client();

        client.createCard(client);

    }
}
