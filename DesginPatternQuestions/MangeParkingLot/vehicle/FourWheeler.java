package MangeParkingLot.vehicle;

public class FourWheeler extends Vehicle{
    private int id;

    public FourWheeler(int id) {
        super(VehicleType.FOUR_WHEELER);
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
