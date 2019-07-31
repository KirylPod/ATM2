package client;

import card.Card;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public abstract class AbstractClient  {

    private String clientId;
    private Card card;

    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public String getClientId() { return clientId; }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public BufferedReader getBr() {
        return br;
    }

    public void setBr(BufferedReader br) {
        this.br = br;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public AbstractClient(Card card) {
        this.card = card;
    }

}
