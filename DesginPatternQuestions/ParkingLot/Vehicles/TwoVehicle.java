package Vehicles;

public class TwoVehicle extends BaseVehicle{

    public TwoVehicle(long newNumberPlate) {
        super(newNumberPlate);
    }
    @Override
    public long getVehiclePlateNo() {
        return this.numberPlate;
    }

    @Override
    public int getVehicleId() {
        return this.v_id;
    }
}
