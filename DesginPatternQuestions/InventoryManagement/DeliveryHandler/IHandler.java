package InventoryManagement.DeliveryHandler;

import InventoryManagement.Warehouses.Warehouse;

public abstract class IHandler {
    protected IHandler handler;

    protected Warehouse warehouseInstance = Warehouse.getInstance();
    
    public void setHandler(IHandler handler) {
        this.handler = handler;
    }

    public void handle(Context context) {
        boolean result = process(context);
        if (!result) {
            System.out.println("Chain failed: "+ context.getFailureMessage());
            return;
        }

        if (this.handler!=null) {
            handler.handle(context);
        }
    }

    public abstract boolean process(Context context);
}
