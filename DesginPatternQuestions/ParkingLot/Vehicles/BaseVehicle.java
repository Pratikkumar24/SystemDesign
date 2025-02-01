package Vehicles;
import java.util.Random;

import Database.ParkingDatabase;
import interfaces.Vehicle;

public abstract class BaseVehicle implements Vehicle {
    int v_id;
    long numberPlate;
    private Random random; 

    public BaseVehicle(long newNumberPlate) {
        ParkingDatabase parkingDatabase = ParkingDatabase.getInstances();
        random = new Random();
        do {
            this.v_id = random.nextInt(100);
        } while(parkingDatabase.isVehicleIdPresent(this.v_id));
        this.numberPlate = newNumberPlate;
    } 
}