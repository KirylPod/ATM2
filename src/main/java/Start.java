
import atm.machine.Atm;
import atm.money.AtmMoney;
import atm.machine.AtmEvents;
import client.Client;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.takeCard();

        Atm atm = new Atm();
        atm.validId(client.getCard());




    }
}
