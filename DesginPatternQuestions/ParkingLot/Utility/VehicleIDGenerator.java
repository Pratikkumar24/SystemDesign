package Utility;

import Database.ParkingDatabase;

public class VehicleIDGenerator implements IDGenerator {

    protected ParkingDatabase parkingDatabase = ParkingDatabase.getInstances();

    @Override
    public int generateId() {
        int id = 0;
        do {
            id = random.nextInt(100);
        } while(parkingDatabase.isVehicleIdPresent(id));
        parkingDatabase.addVehicleId(id);
        return id;
    }
}
