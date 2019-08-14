package atm;

import java.io.IOException;

public class AtmEvents {

    public String getValue(String value) throws IOException {
        System.out.println("На вашем счету = " + value);
        return value;
    }
    public void errorClientId() throws IOException {
        System.out.println("Введенный номер карты не соотвествует заданному формату");
 //       createCard();
    }

    public void errorClientPin(String clientPin) throws IOException {
        System.out.println("Введенный пин-код не соотвествует заданному формату");
 //       cashMachine.actionPin(cardPin);
    }

    public void errorAccountPin(String clientPin) throws IOException {
        System.out.println("Вы ввели не верный PIN");
        //       cashMachine.actionPin(cardPin);
    }

    public void errorGetCashId() throws IOException {
        System.out.println("Недостаточно средств на счете");
//        cashMachine.yesNo();
    }

    public void errorGetCashMachine() throws IOException {
        System.out.println("Недостаточно средств в банкомате");
//        cashMachine.yesNo();
    }

    public void errorSetCashMachine() throws IOException {
        System.out.println("Сумма пополнения не должна превышать 1 000 000");
//        cashMachine.yesNo();
    }
    public void successCardId() throws IOException {
        System.out.println("Спасибо за то, что вы с нами. Удачного дня");
        System.out.println(" ");
//        client.newCashMachine();

    }
    public void errorInputOperation() throws IOException {
        System.out.println("Данной операции не существует");
//        cashMachine.operation();
    }

    public void errorInputYesNo() throws IOException {
        System.out.println("Данной операции не существует");
//        cashMachine.yesNo();
    }
}
