package be.multimedi.restoapp.model.enums;

public enum Star {
    ONE("*"),
    TWO("**"),
    THREE("***"),
    FOUR("****"),
    FIVE("*****");

    private String value;

    Star(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
