package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class ProductSelection implements VendingStates{
    @Override
    public void pressInsertButton(Machine machine) {
        System.out.println("[-] In ProductSelection state, no buttom to press for inserting!!");
        return;
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("[-] In ProductSelection state, coins already inserted!!");
        return;
    }

    @Override
    public void selectProduct(Machine machine) {
        System.out.println("[-] Already in product selection state!!");
        return;
    }

    @Override
    public void refundFullMoney(Machine machine) {
        //Yet to implement
        return;
    }

    @Override
    public void chooseProduct(int code) {
        //Yet to implement
        return;
    }

    @Override
    public Item dispenceProduct() {
        System.out.println("[-] Please choose a product to dispence");
        return null;
    }
}
