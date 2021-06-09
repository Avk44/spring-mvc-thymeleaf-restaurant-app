package be.multimedi.restoapp.model.enums;

public enum MoneyType {
    EURO("€"),
    DOLLAR("$");

    private String symbol;

    MoneyType(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbol() {
        return symbol;
    }
}
