package enums;

public enum State {
    ALABAMA(1),
    ALASKA(2),
    ARIZONA(3),
    ;

    private int value;

    State(int i) {
        this.value = i;
    }

    public int getValue() {
        return value;
    }
}
