package DecoratorPattern.ConcreteDecoratorClasses;

import DecoratorPattern.DecoratorClass.FeatureDecorator;
import DecoratorPattern.Interface.BaseVehicle;

public class musicSystem extends FeatureDecorator {

    public musicSystem(BaseVehicle baseVehicle) {
        super(baseVehicle);
    }
    @Override
    public void getDescription() {
        System.out.println("-> music system added");
    }

    @Override
    public int getCost() {
        return baseVehicle.getCost() + 600;
    }
    
}
