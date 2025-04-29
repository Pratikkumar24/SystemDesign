package meetingScheduler.Strategy;

import meetingScheduler.Entity.MeetingRoom;
import meetingScheduler.Database.Repository;

public class LeaseSpaceStrategy implements SearchStrategy {
    
    public Repository repository;

    public LeaseSpaceStrategy(Repository repository) {
        this.repository = repository;   
    }

    @Override
    public MeetingRoom findMeetingRoom(int date, int startTime, int endTime) {
        return null;
    }   
}
