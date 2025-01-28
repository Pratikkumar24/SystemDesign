package FactoryAndAbstractPattern.luxuryVehicles;

import FactoryAndAbstractPattern.Interface.vehicle;

public class mercedes implements vehicle {
    int price;
    public mercedes(int carPrice) {
        this.price = carPrice;
    }
    @Override
    public void getDescription() {
        System.out.println("This is a mercedes car and its luxary");
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
