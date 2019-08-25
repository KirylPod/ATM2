package enums;

public enum Menu {

    CHECK_BALANCE("1 - Проверить баланс"),
    GET_CASH("2 - Снять наличные"),
    SET_CASH("3 - Пополнить баланс"),
    RETURN_CARD("4 - Вернуть карту");

    private String type;

    Menu(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}