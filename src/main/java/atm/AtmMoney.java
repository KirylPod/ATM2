package atm;

import interfaces.AtmMoneyInterface;
import lombok.Getter;
import lombok.Setter;

import java.io.*;

@Getter
@Setter
public abstract class AtmMoney implements AtmMoneyInterface {

    private int money;
    private File file;

    @Override
    public void getAtmMoney() throws IOException {
        file = new File("src/main/resources/atmCash");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        setMoney(Integer.parseInt(reader.readLine()));

    }

    @Override
    public void setAtmMoney() throws IOException {
        FileWriter writer = new FileWriter(file, false);
        writer.write(String.format("%.2f", getMoney()).replace(',', '.'));
        writer.close();

    }
}
