package atm;

import interfaces.AtmInterface;
import interfaces.BankInterface;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractAtm implements AtmInterface {

    private int cash;
    private BankInterface bank;


}
