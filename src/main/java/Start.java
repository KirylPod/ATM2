
import atm.Atm;
import card.Card;
import client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Start {

    public static void main(String[] args) throws IOException {

        Card card = new Card("EmptyId","EmptyPin");
        Client client = new Client(card);
        client.goToAtm();

    }
}
