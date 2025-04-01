package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.MachineManager;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class Idle implements VendingStates {
    @Override
    public void pressInsertButton(MachineManager manager, Machine machine) {
        manager.setState(new RecieveMoney());
        System.out.println("[+] Moving to recieving money");
        return;
    }

    @Override
    public void insertCoin(MachineManager manager, Machine machine, Coin coin) {
        System.out.println("[-] Still in idle state, can't insert coin");
        return;
    }

    @Override
    public void selectProduct(MachineManager manager, Machine machine) {
        System.out.println("[-] Still in idle state, can't select product");
        return;
    }

    @Override
    public int refundFullMoney(MachineManager manager, Machine machine) {
        System.out.println("[-] Still in idle state, No money due");
        return 0;
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        System.out.println("[-] Still in idle state, no product to choose");
        return false;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        System.out.println("[-] Still in idle state, no product due");
        return null;
    }
}
