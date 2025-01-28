package DecoratorPattern.ConcreteBaseClasses;

import DecoratorPattern.Interface.BaseVehicle;

public class bus implements BaseVehicle{

    @Override
    public void getDescription() {
        System.out.println("Brand new Bus");
    }

    @Override
    public int getCost() {
        return 13000;
    }
    
}
