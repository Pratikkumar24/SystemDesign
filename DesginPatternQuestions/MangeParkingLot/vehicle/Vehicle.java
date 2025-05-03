package MangeParkingLot.vehicle;

public abstract class Vehicle {
    VehicleType vehicleType;
    public Vehicle(VehicleType type) {
        this.vehicleType = type;
    }
    abstract public int getVehicleId();
    abstract public VehicleType getVehicleType();
}
