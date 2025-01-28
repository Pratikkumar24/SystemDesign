package DecoratorPattern.ConcreteBaseClasses;

import DecoratorPattern.Interface.BaseVehicle;

public class car implements BaseVehicle {

    @Override
    public void getDescription() {
        System.out.println("Brand new car");
    }

    @Override
    public int getCost() {
        return 1000;
    }
}
