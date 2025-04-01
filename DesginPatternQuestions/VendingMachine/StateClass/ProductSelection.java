package SystemDesign.DesginPatternQuestions.VendingMachine.StateClass;

import SystemDesign.DesginPatternQuestions.VendingMachine.Coin;
import SystemDesign.DesginPatternQuestions.VendingMachine.Item;
import SystemDesign.DesginPatternQuestions.VendingMachine.Machine;
import SystemDesign.DesginPatternQuestions.VendingMachine.MachineManager;
import SystemDesign.DesginPatternQuestions.VendingMachine.VendingStates;

public class ProductSelection implements VendingStates{
    @Override
    public void pressInsertButton(MachineManager manager, Machine machine) {
        System.out.println("[-] In ProductSelection state, no buttom to press for inserting!!");
        return;
    }

    @Override
    public void insertCoin(MachineManager manager, Machine machine, Coin coin) {
        System.out.println("[-] In ProductSelection state, coins already inserted!!");
        return;
    }

    @Override
    public void selectProduct(MachineManager manager, Machine machine) {
        System.out.println("[-] Already in product selection state!!");
        return;
    }

    @Override
    public int refundFullMoney(MachineManager manager, Machine machine) {
        return machine.totalMoney();
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        if(!machine.isProductCodeAvailable(code)) {
            System.out.println("[-] Product is not available..");
            return false;
        }
        machine.setSelectedProductedCode(code);
        return true;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        manager.setState(new DispenseProduct());
        System.out.println("[+] Moving to Dispense Product");
        return null;
    }
}
