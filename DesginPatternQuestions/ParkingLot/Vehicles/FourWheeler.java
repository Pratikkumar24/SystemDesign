package Vehicles;

public class FourWheeler extends BaseVehicle{

    public FourWheeler(long newNumberPlate) { 
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
