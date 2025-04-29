package VendingMachine.StateClass;

import VendingMachine.Coin;
import VendingMachine.Item;
import VendingMachine.Machine;
import VendingMachine.MachineManager;
import VendingMachine.VendingStates;

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
    public void refundFullMoney(MachineManager manager, Machine machine) {
        int money = machine.totalMoney();
        System.out.println("[+] Your leftOver money credited to your account:"+money);
    }

    @Override
    public boolean chooseProduct(MachineManager manager, Machine machine, int code) {
        if(!machine.isProductCodeAvailable(code)) {
            System.out.println("[-] Product is not available..");
            return false;
        }
        machine.setSelectedProductedCode(code);
        manager.setState(new DispenseProduct());
        System.out.println("[+] Moving to Dispense Product");
        return true;
    }

    @Override
    public Item dispenceProduct(MachineManager manager, Machine machine) {
        return null;
    }
}
