package MangeParkingLot.strategy.paymentStrategy;

public class UpiPayment implements Payment {

    String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(int amount) {
        System.out.println("You have paid a amount of "+ amount+" with upi");
    }
    
}
