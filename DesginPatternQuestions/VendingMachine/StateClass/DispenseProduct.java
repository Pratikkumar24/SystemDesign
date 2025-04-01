package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.MachineManager;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class DispenseProduct implements VendingStates {
    @Override
    public void pressInsertButton(MachineManager manager, Machine machine) {
        System.out.println("[-] In DispenceProduct state, please let me know if you want to dispence product or want to cancel it");
    }

    @Override
    public void insertCoin(MachineManager manager, Machine machine, Coin coin) {
        System.out.println("[-] In DispenceProduct state, please let me know if you want to dispence product or want to cancel it");
    }

    @Override
    public void selectProduct(MachineManager manager, Machine machine) {
        //todo - Implement replacement of product
    }

    @Override
    public int refundFullMoney(MachineManager manager, Machine machine) {
        int money = machine.totalMoney();
        machine.removeCoins(money);
        manager.setState(new Idle());
        return money;
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        return false;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        Item item = machine.getProduct();
        //Return the refund (or just print the refund)
        manager.setState(new Idle());
        return item;
    }
}
