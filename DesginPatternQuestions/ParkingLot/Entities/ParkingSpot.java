package Entities;

import Database.ParkingDatabase;
import Utility.IDGenerator;
import Utility.ParkingSpotIdGenerator;
import interfaces.Vehicle;

public class ParkingSpot {
    int parkingSpotId;
    int parkingSpotPrice;
    Vehicle vehicle;
    boolean isEmpty;
    ParkingDatabase parkingDatabase;
    protected IDGenerator idGenerator;

    public ParkingSpot(Vehicle v, int price) {
        idGenerator = new ParkingSpotIdGenerator();
        parkingDatabase = ParkingDatabase.getInstances(); 
        this.vehicle = v;
        this.parkingSpotPrice = price;
        isEmpty = false;
        
        updatedId();
    }

    public int getParkingSpotPrice() {
        return parkingSpotPrice;
    }

    public void updatedId() {
        this.parkingSpotId = idGenerator.generateId();
    }

    public void updateSpot() {
        parkingDatabase.addParkingSpotId(parkingSpotId);
    }

    public void releaseSpot() {
        isEmpty = true;
        vehicle = null;
        parkingDatabase.removeParkingSpotId(parkingSpotId);
    }
}