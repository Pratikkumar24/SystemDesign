package FactoryAndAbstractPattern;

import FactoryAndAbstractPattern.Interface.vehicle;
import FactoryAndAbstractPattern.abstractFactoryPattern.abstractFactoryDesign;

public class Main {
    public static void main(String args[]) {
        System.out.println("--Factory And Abstract Factory Patter --");
        abstractFactoryDesign carFactory = new abstractFactoryDesign();
        vehicle swift = carFactory.getVehicle("SWIFT", 100);
        vehicle jaguar = carFactory.getVehicle("JAGUAR", 400);

        swift.displayFeatures();
        jaguar.displayFeatures();
    }
}
