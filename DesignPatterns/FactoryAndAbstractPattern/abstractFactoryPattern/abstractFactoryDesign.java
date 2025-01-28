package FactoryAndAbstractPattern.abstractFactoryPattern;

import FactoryAndAbstractPattern.Interface.vehicle;
import FactoryAndAbstractPattern.factoryPattern.luxuryCarFactory;
import FactoryAndAbstractPattern.factoryPattern.ordinaryCarFactory;

public class abstractFactoryDesign {
    private final String jaguar = "JAGUAR";
    private final String mercedes = "MERCEDES";
    private final String maruti = "MARUTI";
    private final String swift = "SWIFT";
    private final String vitara = "VITARA";
    
    private luxuryCarFactory luxury = new luxuryCarFactory();
    private ordinaryCarFactory ordinary = new ordinaryCarFactory();

    public vehicle getVehicle(String car, int price) {
        switch (car) {
            case jaguar:
                return luxury.getVehicle(car, price);
            case mercedes:
                return luxury.getVehicle(car, price);
            case swift:
                return ordinary.getVehicle(car, price);
            case vitara:
                return ordinary.getVehicle(car, price);
            case maruti:
                return ordinary.getVehicle(car, price);
            default:
                return null;
        }
    }
}
