package interfaces;

import atm.machine.Atm;
import atm.machine.AtmEvents;
import client.Client;

import java.io.IOException;

public interface ClientInterface {

    public Client goToAtm(Atm atm, AtmEvents events) throws IOException;

    public void takeCard(Atm atm, AtmEvents events) throws IOException;

}
