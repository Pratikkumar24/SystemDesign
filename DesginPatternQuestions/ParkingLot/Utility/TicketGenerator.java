package Utility;

import Database.ParkingDatabase;

public class TicketGenerator implements IDGenerator {
    ParkingDatabase parkingDatabase = ParkingDatabase.getInstances();

    @Override
    public int generateId() {
        int id = 0;
        do {
            id = random.nextInt(100);
        } while(parkingDatabase.isTicketIdPresent(id)); 
        parkingDatabase.addTicketId(id);
        return id;
    }
}
