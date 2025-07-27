package InventoryManagement.DeliveryHandler;

public class PaymentTransaction extends IHandler{

    public PaymentTransaction(IHandler handler) {
        setHandler(handler);
    }

    @Override
    public boolean process(Context context) {
        int totalMoneyRequired = context.getTotalQuantity() * context.getProduct().getProductPrice();
        boolean paymentStatus = totalMoneyRequired<=context.getMoneyPaid();
        if (!paymentStatus) {
            context.setFailureMessage("Not enough paid!!");
            return false;
        }

        return true;
    }
}
