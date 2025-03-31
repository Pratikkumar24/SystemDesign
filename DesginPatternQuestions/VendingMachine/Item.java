package SystemDesign.DesginPatternQuestions.VendingMachine;

public class Item {
    int price;
    String name;
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
