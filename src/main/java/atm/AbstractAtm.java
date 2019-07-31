package atm;

import card.Card;
import interfaces.AtmInterface;
import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Getter
@Setter
@AllArgsConstructor

public abstract class AbstractAtm {

   public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


}
