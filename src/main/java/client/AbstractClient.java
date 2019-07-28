package client;

import card.Card;
import interfaces.ClientInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractClient implements ClientInterface {

    private String clientId, clientPin;

    private Card card;

    private int cash;

}
