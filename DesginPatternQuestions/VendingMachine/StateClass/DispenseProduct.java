package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class DispenseProduct implements VendingStates {
    @Override
    public void pressInsertButton(Machine machine) {
    }

    @Override
    public void insertCoin(Coin coin) {
    }

    @Override
    public void selectProduct(Machine machine) {
    }

    @Override
    public void refundFullMoney(Machine machine) {
    }

    @Override
    public void chooseProduct(int code) {
    }

    @Override
    public Item dispenceProduct() {
        //Yet to implement
        return new Item(null, 0);
    }
}
