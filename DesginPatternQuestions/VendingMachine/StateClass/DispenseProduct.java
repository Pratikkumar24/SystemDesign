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
        System.out.println("[-] In DispenceProduct state, cant select any product");
    }

    @Override
    public void refundFullMoney(MachineManager manager, Machine machine) {
        int money = machine.totalMoney();
        machine.removeCoins(money);
        manager.setState(new Idle());
        System.out.println("[+] LeftOver money is credit to your account: "+money);
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        return false;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        System.out.println("[+] Despensing product....");
        Item item = machine.getProduct();
        refundFullMoney(manager, machine);
        manager.setState(new Idle());
        return item;
    }
}
