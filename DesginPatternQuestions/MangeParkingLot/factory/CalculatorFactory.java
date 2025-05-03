package MangeParkingLot.factory;

import MangeParkingLot.strategy.calculationStrategy.FourWheelerPPCalculator;
import MangeParkingLot.strategy.calculationStrategy.ParkingPriceCalculator;
import MangeParkingLot.strategy.calculationStrategy.ThreeWheelerPPCalculator;
import MangeParkingLot.strategy.calculationStrategy.TwoWheelerPPCalculator;
import MangeParkingLot.vehicle.VehicleType;

public class CalculatorFactory {
    public ParkingPriceCalculator getParkingPriceCalculator(VehicleType type) {
        switch (type) {
            case TWO_WHEELER:
                return new TwoWheelerPPCalculator();
            case THREE_WHEELER:
                return new ThreeWheelerPPCalculator();
            case FOUR_WHEELER:
                return new FourWheelerPPCalculator();
            default:
                return null;
        }
    }
}
