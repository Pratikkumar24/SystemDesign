package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;
import SystemDesign.DesginPatternQuestions.VendingMachine.MachineManager;

public class RecieveMoney implements VendingStates{
    @Override
    public void pressInsertButton(MachineManager manager, Machine machine) {
        System.out.println("[-] In Recive money state, no buttom to press for inserting!!");
        return;
    }

    @Override
    public void insertCoin(MachineManager manager,Machine machine, Coin coin) {
        machine.addCoins(coin); 
        return;
    }

    @Override
    public void selectProduct(MachineManager manager, Machine machine) {
        manager.setState(new ProductSelection());
        System.out.println("[+] Moving to product selection state");
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
