package MangeParkingLot.vehicle;

public class ThreeWheeler extends Vehicle{
    private int id;
    public ThreeWheeler(int id) {
        super(VehicleType.THREE_WHEELER);
        this.id = id;
    }

    @Override
    public int getVehicleId() {
        return this.id;
    }
    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
