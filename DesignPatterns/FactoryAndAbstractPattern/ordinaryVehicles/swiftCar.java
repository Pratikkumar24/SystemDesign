package FactoryAndAbstractPattern.ordinaryVehicles;

import FactoryAndAbstractPattern.Interface.vehicle;
public class swiftCar implements vehicle {
    int price;
    public swiftCar(int carPrice) {
        this.price = carPrice;
    }
    @Override
    public void getDescription() {
        System.out.println("This is a swift car and its ordinary");
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
