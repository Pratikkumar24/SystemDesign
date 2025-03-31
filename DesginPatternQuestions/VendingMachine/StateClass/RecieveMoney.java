package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class RecieveMoney implements VendingStates{
    @Override
    public void pressInsertButton(Machine machine) {
        System.out.println("[-] In Recive money state, no buttom to press for inserting!!");
        return;
    }

    @Override
    public void insertCoin(Coin coin) {
        //todo - yet to complete
        return;
    }

    @Override
    public void selectProduct(Machine machine) {
        System.out.println("[-] In Recive money state, no buttom to press for inserting!!");
        return;
    }

    @Override
    public void refundFullMoney(Machine machine) {
        System.out.println("[-] Still in idle state, No money due");
        return;
    }

    @Override
    public void chooseProduct(int code) {
        System.out.println("[-] Still in idle state, no product to choose");
        return;
    }

    @Override
    public Item dispenceProduct() {
        System.out.println("[-] Still in idle state, no product due");
        return null;
    }
}
