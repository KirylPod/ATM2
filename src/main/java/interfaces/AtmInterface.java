package interfaces;

import java.io.IOException;

public interface AtmInterface {

    public String inputId(String clientId) throws IOException;

    public String inputPin(String clientPin) throws IOException;

    public String inputCash();

    public String getCash();

    public String setCash();

}
