package FactoryAndAbstractPattern.ordinaryVehicles;

import FactoryAndAbstractPattern.Interface.vehicle;

public class maruti implements vehicle{
    int price;
    public maruti(int carPrice) {
        this.price = carPrice;
    }
    @Override
    public void getDescription() {
        System.out.println("This is a marurti car and its ordinary");
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
