package DecoratorPattern.DecoratorClass;

import DecoratorPattern.Interface.BaseVehicle;

public abstract class FeatureDecorator implements BaseVehicle {
    // Making this abstract helps in not implementing the methods from baseVehicle
    protected BaseVehicle baseVehicle;
    
    public FeatureDecorator(BaseVehicle baseVehicle) {
        this.baseVehicle = baseVehicle;
    }

    // @Override
    // public int getCost() {
    //     return this.baseVehicle.getCost();
    // }
}
