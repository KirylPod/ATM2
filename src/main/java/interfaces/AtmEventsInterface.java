package interfaces;

import atm.machine.Atm;
import atm.machine.AtmEvents;
import client.Client;
import client.card.Card;

import java.io.IOException;

public interface AtmEventsInterface {

    public void errorAccountId(Client client, AtmEvents events) throws IOException;

    public void errorClientPin(Card card, Atm atm) throws IOException;

    public void errorAccountPin(Card card, Atm atm) throws IOException;

    public void errorGetCashId(Atm atm, Client client) throws IOException;

    public void errorGetCashMachine(Atm atm, Client client) throws IOException;


    public void errorSetCashMachine(Atm atm, Client client) throws IOException;


    public void successCardId(Client client) throws IOException;


    public void errorInputOperation(Atm atm, Client client) throws IOException;


    public void errorInputYesNo(Atm atm, Client client) throws IOException;


}
