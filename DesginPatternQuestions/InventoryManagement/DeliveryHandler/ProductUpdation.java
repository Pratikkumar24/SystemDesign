package InventoryManagement.DeliveryHandler;

public class ProductUpdation extends IHandler{

    public ProductUpdation(IHandler handler) {
        setHandler(handler);
    }

    @Override
    public boolean process(Context context) {
        boolean isProductAvailability = warehouseInstance.enoughQuantity(
            context.getProduct().getProductType(), context.getTotalQuantity()
        );
        context.setProductAvailability(isProductAvailability);
        if (!isProductAvailability) {
            context.setFailureMessage("Product is not available!!");
            return false;
        }

        return true;
    } 
}
