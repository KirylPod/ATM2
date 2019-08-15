package atm.money;

import atm.money.AbstractAtmMoney;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.IOException;


public class AtmMoney extends AbstractAtmMoney {


    @Override
    public String getMoney() {
        return super.getMoney();
    }

    @Override
    public File getFile() {
        return super.getFile();
    }

    @Override
    public void setMoney(String money) {
        super.setMoney(money);
    }

    @Override
    public void setFile(File file) {
        super.setFile(file);
    }

    @Override
    public String reedAtmMoney() throws IOException {
        return super.reedAtmMoney();
    }

    @Override
    public void writeAtmMoney() throws IOException {
        super.writeAtmMoney();
    }
}
