package atm;

import interfaces.AtmKeyboardInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Pattern;

public abstract class AbstractAtmKeyboard implements AtmKeyboardInterface {

    private BufferedReader input;
    private AtmEvents error;
    private Atm atm;

    @Override
    public void operation() throws IOException {
        System.out.println("1 - Проверить баланс");
        System.out.println("2 - Снять наличные");
        System.out.println("3 - Пополнить баланс");
        System.out.println("4 - Вернуть карту");

        String num = input.readLine();
        if (Pattern.matches("^[1-4]{1}", num)) {
            switch (num) {
                case "1":
                    atm.checkBalance();
//                    account.setCardValue(cashMachineDriver.getValue(account.getCardValue()));
                    yesNo();
                    break;
                case "2":
//                    account.setCardValue(cashMachineDriver.getCash(account.getCardValue()));
                    yesNo();
                    break;
                case "3":
//                    account.setCardValue(cashMachineDriver.setValue(account.getCardValue()));
                    yesNo();
                    break;
                case "4":
                    System.out.println("Заберите вашу карту");
//                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
//                    cashMachineMoney.setCashMachineMoney();
//                    cashMashinePrint.successCardId();
                    break;
            }

        } else {
            error.errorInputOperation();

        }
        input.close();
    }

    @Override
    public void yesNo() throws IOException {
        System.out.println("Желаете продолжить?");
        System.out.println("1 - Продолжить");
        System.out.println("2 - Отмена");
        String num = input.readLine();


        if (Pattern.matches("^[1-2]{1}", num)) {
            switch (num) {
                case "1":
                    operation();
                    break;
                case "2":
                    System.out.println("Заберите вашу карту");
//                    bankServer.setNewValue(account.getCardId(), account.getCardValue());
//                    cashMachineMoney.setCashMachineMoney();
//                    cashMashinePrint.successCardId();
                    break;
            }
        } else {
            error.errorInputYesNo();
        }
        input.close();
    }
}

