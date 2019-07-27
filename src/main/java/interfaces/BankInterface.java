package interfaces;

import java.util.ArrayList;

public interface BankInterface {

    public void setClient();

    void getClient();

    String getName();

    ArrayList<AtmInterface> getAtmList();

    ArrayList<ClientInterface> getClientList();

}
