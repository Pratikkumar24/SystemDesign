package MangeParkingLot.factory;

import MangeParkingLot.vehicle.FourWheeler;
import MangeParkingLot.vehicle.ThreeWheeler;
import MangeParkingLot.vehicle.TwoWheeler;
import MangeParkingLot.vehicle.Vehicle;
import MangeParkingLot.vehicle.VehicleType;

public class VehicleFactory {
    public Vehicle getVehicleByType(VehicleType type, int id) {
        switch (type) {
            case TWO_WHEELER:
                return new TwoWheeler(id);
            case THREE_WHEELER:
                return new ThreeWheeler(id);
            case FOUR_WHEELER:
                return new FourWheeler(id);
            default:
                return null;
        }
    }
}
