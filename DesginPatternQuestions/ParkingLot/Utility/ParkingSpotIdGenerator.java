package Utility;

import Database.ParkingDatabase;

public class ParkingSpotIdGenerator implements IDGenerator {

    protected ParkingDatabase parkingDatabase = ParkingDatabase.getInstances();

    @Override
    public int generateId() {
        int id = 0;
        do {
            id = random.nextInt(100);
        } while(parkingDatabase.isParkingSpotPresent(id));
        parkingDatabase.addParkingSpotId(id);
        return id;
    }
}
