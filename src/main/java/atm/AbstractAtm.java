package atm;

import card.Card;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Getter
@Setter
@AllArgsConstructor

public abstract class AbstractAtm {
    private Card card;
    private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


}
