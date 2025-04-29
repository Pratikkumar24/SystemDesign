package VendingMachine;

public class Item {
    private int price;
    private String name;
    public Item(String name, int price) {
        this.price = price;
        this.name = name;
    }
    public String getItemName() {
        return this.name;
    }
    public int getItemValue() {
        return this.price;
    }
}
