package VendingMachineV2;

import java.util.HashMap;
import java.util.Scanner;

import VendingMachineV2.Products.Product;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Coin> mp = new HashMap<>();
        mp.put(1, Coin.ONE);
        mp.put(2, Coin.TWO);
        mp.put(5, Coin.FIVE);
        mp.put(10, Coin.TEN);
        mp.put(20, Coin.TWENTY);

        Repository repository = Repository.getInstance();

        Machine vendingMachine = new Machine(repository);
        int option = 0;
        while(option!=-1) {
            System.out.println("1. Insert Coin");
            System.out.println("2. Select product");
            System.out.println("3. Dispense product");
            System.out.println("4. Return full money");
            System.out.println("5. Show products");
            System.out.println("-1. Exit\n");
           
            repository.showBalance();
            Product selectedProduct = repository.getSelectedProduct();
            if (selectedProduct == null) {
                System.out.println("No product in the bucket!!");
            } else {
                System.out.println("Current product selected is "+ selectedProduct.getProductName()+" with code: "+ selectedProduct.getProductCode());
            }

            System.out.print("[+] Choose an option:");
            option = sc.nextInt();
            System.out.println();
            switch (option) {
                case 1:
                    System.out.println("insert Valid coins: 1, 2, 5, 10, 20 -> ");
                    int money = sc.nextInt();
                    if (mp.containsKey(money)) {
                        vendingMachine.insertCoin(mp.get(money));
                    } else {
                        System.out.println("Not a proper validation!!");
                    }
                    break;

                case 2:
                    System.out.println("Please enter code: ");
                    int code = sc.nextInt();
                    repository.setSelectedProduct(vendingMachine.selectProduct(code));
                    break;

                case 3:
                    vendingMachine.dispenceProduct(selectedProduct);
                    break;

                case 4:
                    vendingMachine.refundFullMoney();
                    break;

                case 5:
                    vendingMachine.showProducts();
                    break;

                case -1:
                    System.out.println("....Exiting Vending machine.....");
                    break;
            
                default:
                    break;
            }
        }
        sc.close();
    }
}
