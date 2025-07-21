package VendingMachineV2;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20);

    public final int value;
    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
