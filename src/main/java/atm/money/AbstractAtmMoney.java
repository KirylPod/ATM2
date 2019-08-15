package atm.money;

import interfaces.AtmMoneyInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
public abstract class AbstractAtmMoney implements AtmMoneyInterface {

    private String money;
    private File file;

    @Override
    public String reedAtmMoney() throws IOException {


        file = new File("src/main/resources/atmCash");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        return money = reader.readLine();
    }

    @Override
    public void writeAtmMoney() throws IOException {
        FileWriter writer = new FileWriter(file, false);
        writer.write(String.format("%.2f", getMoney()).replace(',', '.'));
        writer.close();

    }
}
