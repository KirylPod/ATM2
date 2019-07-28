package interfaces;

import java.util.ArrayList;

public interface BankInterface {

    public void checkId(String clientId);

    public void checkPin(String clientPin);

    public void setClient();

    public void getClient();

    String getName();



}
