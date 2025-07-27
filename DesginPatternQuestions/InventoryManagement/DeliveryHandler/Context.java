package InventoryManagement.DeliveryHandler;

import InventoryManagement.Products.Product;

public class Context {
    private Product product;
    private int warehouseId;
    private int totalQuantity;
    private int userId;
    private int moneyPaid;
    private boolean isAvailable;
    private boolean isPaymentSuccessful;
    private boolean isProductUpdated;
    private boolean isDeliveryScheduled;

    public String failureMessage;

    public Context(Product product, int quantity, int userId) {
        this.product = product;
        this.totalQuantity = quantity;
        this.userId = userId;
    }

    public void setWarehouseId(int id) {
        this.warehouseId = id;
    }

    public int getWarehouseId() {
        return this.warehouseId;
    }
    
    public Product getProduct() {
        return this.product;
    }

    public void payMoney(int money) {
        this.moneyPaid = money;
    }

    public int getMoneyPaid() {
        return this.moneyPaid;
    }

    public void setProductAvailability(boolean available) {
        this.isAvailable = available;
    }

    public void setPaymentTransaction(boolean transactionStatus) {
        this.isPaymentSuccessful = transactionStatus;
    }

    public void setProductUpdated(boolean isProductUpdated) {
        this.isProductUpdated = isProductUpdated;
    }

    public void setDeliveryStatus(boolean isReadyForDelivery) {
        this.isDeliveryScheduled = isReadyForDelivery;
    }
    
    public int getTotalQuantity() {
        return totalQuantity;
    }

    public int getUserId() {
        return userId;
    }

    public void setFailureMessage(String message) {
        this.failureMessage = message;
    }

    public String getFailureMessage() {
        return this.failureMessage;
    }

    public boolean isSuccess() {
        return isAvailable && isPaymentSuccessful && isProductUpdated && isDeliveryScheduled;
    }
}
