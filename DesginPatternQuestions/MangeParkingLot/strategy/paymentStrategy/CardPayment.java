package MangeParkingLot.strategy.paymentStrategy;

public class CardPayment implements Payment{

    long cardNumber;
    int expDay;
    int expYear;

    public CardPayment(long cardNumber, int expDay, int expYear) {
        this.cardNumber = cardNumber;
        this.expDay = expDay;
        this.expYear = expYear;
    }

    @Override
    public void pay(int amount) {
        System.out.println("You have paid a amount of "+ amount+" with card");
    }
    
}
