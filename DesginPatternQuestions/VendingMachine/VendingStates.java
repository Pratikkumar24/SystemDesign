package SystemDesign.DesginPatternQuestions.VendingMachine;

public interface VendingStates {
    void pressInsertButton(Machine machine);
    void insertCoin(Coin coin);
    void selectProduct(Machine machine);
    void refundFullMoney(Machine machine);
    void chooseProduct(int code);
    Item dispenceProduct();
}
