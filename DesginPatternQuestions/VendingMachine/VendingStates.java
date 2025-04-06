package SystemDesign.DesginPatternQuestions.VendingMachine;

public interface VendingStates {
    void pressInsertButton(MachineManager manager, Machine machine);
    void insertCoin(MachineManager manager, Machine machine, Coin coin);
    void selectProduct(MachineManager manager, Machine machine);
    void refundFullMoney(MachineManager manager, Machine machine);
    boolean chooseProduct(MachineManager manager, Machine machine, int code);
    Item dispenceProduct(MachineManager manager, Machine machine);
}
