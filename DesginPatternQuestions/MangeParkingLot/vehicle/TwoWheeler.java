package MangeParkingLot.vehicle;

public class TwoWheeler extends Vehicle{
    private int id;

    public TwoWheeler(int id) {
        super(VehicleType.TWO_WHEELER);
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
