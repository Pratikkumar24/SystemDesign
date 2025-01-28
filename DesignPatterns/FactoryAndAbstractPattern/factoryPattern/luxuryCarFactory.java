package FactoryAndAbstractPattern.factoryPattern;

import FactoryAndAbstractPattern.Interface.vehicle;
import FactoryAndAbstractPattern.luxuryVehicles.jaguar;
import FactoryAndAbstractPattern.luxuryVehicles.mercedes;

public class luxuryCarFactory {
    private final String jaguar = "JAGUAR";
    private final String mercedes = "MERCEDES";

    public vehicle getVehicle(String vString, int price) {
        switch (vString) { 
            case jaguar:
                return new jaguar(price);
            case mercedes:
                return new mercedes(price);  
            default:
                return null;
        }
    }
}
