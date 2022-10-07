package utils.enums;

public enum KeysOfParameters {
    USERNAME("username"),
    PASSWORD("password"),
    ITEM_ID("panvelCode");

    public final String value;
    KeysOfParameters(String value) {
        this.value = value;
    }
}
