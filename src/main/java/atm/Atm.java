package atm;

import bank.Bank;
import card.Card;
import client.Client;
import interfaces.AtmInterface;

import java.io.BufferedReader;
import java.io.IOException;

public class Atm extends AbstractAtm {

    public Atm(Card card) {
        super(card);
    }


}



