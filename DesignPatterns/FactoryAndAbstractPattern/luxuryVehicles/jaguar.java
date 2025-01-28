package FactoryAndAbstractPattern.luxuryVehicles;

import FactoryAndAbstractPattern.Interface.vehicle;

public class jaguar implements vehicle{
    int price;
    public jaguar(int carPrice) {
        this.price = carPrice;
    }
    @Override
    public void getDescription() {
        System.out.println("This is a jaguar car and its luxuary");
    }

    @Override
    public void getPrice() {
        System.out.println(" Price:"+this.price);
    }

    @Override
    public void displayFeatures() {
        System.out.println("Features -->");
        this.getDescription();
        this.getPrice();
    }
}
