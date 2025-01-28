package DecoratorPattern.ConcreteDecoratorClasses;

import DecoratorPattern.DecoratorClass.FeatureDecorator;
import DecoratorPattern.Interface.BaseVehicle;

public class seatCover extends FeatureDecorator {
    
    public seatCover(BaseVehicle baseVehicle) {
        super(baseVehicle);
    }

    @Override
    public void getDescription() {
        System.out.println("-> new seat added");
    }

    @Override
    public int getCost() {
        return baseVehicle.getCost() + 300;
    }
    
}
