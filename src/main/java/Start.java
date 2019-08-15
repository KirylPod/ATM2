
import atm.machine.Atm;
import atm.money.AtmMoney;
import atm.machine.AtmEvents;
import client.Client;

import java.io.IOException;

public class Start {

    public static void main(String[] args) throws IOException {

        Client client = new Client();
        client.takeCard();

        AtmEvents events = new AtmEvents();
        AtmKeyboard keyboard = new AtmKeyboard();
        AtmMoney atmMoney = new AtmMoney();
        Atm atm = new Atm(atmMoney, events, keyboard);
        atm.validId(client.getCard());




    }
}
