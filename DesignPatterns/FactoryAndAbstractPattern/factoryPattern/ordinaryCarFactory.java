package FactoryAndAbstractPattern.factoryPattern;

import FactoryAndAbstractPattern.ordinaryVehicles.*;
import FactoryAndAbstractPattern.Interface.vehicle;

public class ordinaryCarFactory {
    private final String maruti = "MARUTI";
    private final String swift = "SWIFT";
    private final String vitara = "VITARA";


    public vehicle getVehicle(String vString, int price) {
        switch (vString) {
            case maruti:
                return new maruti(price);
            case swift:
                return new swiftCar(price);
            case vitara:
                return new vitra(price);  
            default:
                return null;
        }
    }
}
