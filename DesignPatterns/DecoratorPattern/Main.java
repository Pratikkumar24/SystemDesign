package DecoratorPattern;

import DecoratorPattern.ConcreteBaseClasses.bus;
import DecoratorPattern.ConcreteBaseClasses.car;
import DecoratorPattern.ConcreteDecoratorClasses.musicSystem;
import DecoratorPattern.ConcreteDecoratorClasses.seatCover;
import DecoratorPattern.Interface.BaseVehicle;

public class Main {
    public static void main(String[] args) {
        System.out.println("DECORATOR PATTERN");
        BaseVehicle carVehicle = new car();
        System.out.println("Cost of Car:"+ carVehicle.getCost());
        carVehicle.getDescription();

        carVehicle = new seatCover(carVehicle);
        carVehicle.getDescription();

        System.out.println("Cost of Car:"+ carVehicle.getCost());
        carVehicle = new musicSystem(carVehicle);
        carVehicle.getDescription();

        System.out.println("Cost of Car:"+ carVehicle.getCost());

        BaseVehicle busVehicle = new bus();
        busVehicle.getDescription();
        System.out.println("Cost of Bus:"+ busVehicle.getCost());
        busVehicle = new seatCover(busVehicle);
        busVehicle.getDescription();

        System.out.println("Cost of Bus:"+ busVehicle.getCost());
        busVehicle = new musicSystem(busVehicle);
        busVehicle.getDescription();

        System.out.println("Cost of Bus:"+ busVehicle.getCost());
    }
}
