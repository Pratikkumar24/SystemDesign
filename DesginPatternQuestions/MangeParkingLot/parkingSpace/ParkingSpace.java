package MangeParkingLot.parkingSpace;

import MangeParkingLot.vehicle.Vehicle;

public class ParkingSpace {
    private int parkingSpaceId;
    private Vehicle vehicle;
    
    public ParkingSpace(int id) {
        this.parkingSpaceId = id;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getParkingSpaceId() {
        return parkingSpaceId;
    }

    public void removeVehicle() {
        this.vehicle = null;
    }
    
    public Vehicle getVehicle() {
        return this.vehicle;
    }
}
