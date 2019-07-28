package interfaces;

import java.io.IOException;

public interface AtmInterface {

    public String getCard(String cardId);

    public Boolean validId(String cardId) throws IOException;

    public String inputPin(String clientPin) throws IOException;

    public String inputCash();

    public String getCash();

    public String setCash();



}
