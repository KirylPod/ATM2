package interfaces;

import java.io.IOException;
import java.util.ArrayList;

public interface BankInterface {

    public void checkId(String cardId) throws IOException;

    public void checkPin(String clientPin);

    public void setClient();

    public void getClient();

    String getName();



}
