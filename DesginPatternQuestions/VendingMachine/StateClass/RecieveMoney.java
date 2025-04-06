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
        System.out.println("[+] adding "+coin.getValue());
        System.out.println("Total bank balance: "+machine.totalMoney());
        return;
    }

    @Override
    public void selectProduct(MachineManager manager, Machine machine) {
        manager.setState(new ProductSelection());
        System.out.println("[+] Moving to product selection state");
        return;
    }

    @Override
    public void refundFullMoney(MachineManager manager, Machine machine) {
        int money = machine.totalMoney();
        System.out.println("[+] Your account is credited with "+money+" rs");
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        System.out.println("[-] In Recive money state, no product to choose");
        return false;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        System.out.println("[-] In Recive money state, no product due");
        return null;
    }
}
