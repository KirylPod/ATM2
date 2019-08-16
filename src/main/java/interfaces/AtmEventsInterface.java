package interfaces;

import atm.machine.Atm;
import client.Client;
import client.card.Card;

import java.io.IOException;

public interface AtmEventsInterface {

    public void errorAccountId(Client client) throws IOException;

    public void errorClientPin(Card card, Atm atm) throws IOException;

    public void errorAccountPin(Card card, Atm atm) throws IOException;

    public void errorGetCashId(Atm atm) throws IOException;

    public void errorGetCashMachine(Atm atm) throws IOException;


    public void errorSetCashMachine(Atm atm) throws IOException;


    public void successCardId(Client client) throws IOException;


    public void errorInputOperation(Atm atm) throws IOException;


    public void errorInputYesNo(Atm atm) throws IOException;


}
