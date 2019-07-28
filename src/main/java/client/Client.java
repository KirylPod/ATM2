package client;

public class Client extends AbstractClient {

    private String bank;

    public String enterId(String clientId) {

        return clientId;
    }

    public String enterPin(String clientPin) {

        return clientPin;
    }

    public String enterCash(String clientCash) {

        return clientCash;
    }
}
