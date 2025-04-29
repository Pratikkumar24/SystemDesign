package VendingMachine;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5),
    TEN(10),
    TWENTY(20),
    FIFTY(50),
    HUNDRED(100);
    
    private int value;
    Coin(int val) {
        this.value = val;
    }

    public int getValue() {
        return this.value;
    }
}
