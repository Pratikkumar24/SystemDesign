package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Machine {
    private static Machine machine = null;
    private List<ItemSelf> itemSelfs;
    private int bankBalance;
    private int currSelectProductCode = -1;
    private int code = 100;

    private Machine() {
    }

    public void init() {
        this.itemSelfs = new ArrayList<>();
        bankBalance = 0;
    }

    public void showProducts() {
        for(ItemSelf itemSelf: itemSelfs) {
            int code = itemSelf.getCode();
            Item item = itemSelf.getItem();
            boolean isSold = itemSelf.isItemSold();
            StringBuilder output = new StringBuilder();
            output.append("Name:"+item.getItemName()+ " -> "+item.getItemValue()+"rs");
            output.append(" | code:"+code);
            output.append(" | Sold:"+isSold);
            System.out.println(output);
        }
    }
    public void addProduct(String itemName, int itemPrice) {
        Item item = new Item(itemName, itemPrice);
        ItemSelf itemSelf = new ItemSelf(item, code);
        code = code+5;
        this.itemSelfs.add(itemSelf);
    }

    public static Machine getInstance() {
        if(machine == null) {
            synchronized(Machine.class) {
                return new Machine();
            }
        }
        return machine;
    }

    public void addCoins(Coin coin) {
        bankBalance+=coin.getValue();
    }

    public int totalMoney() {
        return bankBalance;
    }

    public boolean isProductCodeAvailable(int code) {
        for(ItemSelf itemSelf:  itemSelfs) {
            int itemCode = itemSelf.getCode();
            boolean isItemSold = itemSelf.isItemSold();
            int itemValue = itemSelf.getItem().getItemValue();
            if(code == itemCode && isItemSold == false && itemValue<=totalMoney()) {
                return true;
            }
        }
        return false;
    }

    public Item getProduct() {
        for(ItemSelf itemSelf:  itemSelfs) {
            if(currSelectProductCode == itemSelf.getCode()) {
                removeCoins(itemSelf.getItem().getItemValue());
                return itemSelf.getItem();
            }
        }
        return null;
    }

    public void removeCoins(int price) {
        bankBalance-=price;
    }

    public void setSelectedProductedCode(int code) {
        this.currSelectProductCode = code;
    }
}
