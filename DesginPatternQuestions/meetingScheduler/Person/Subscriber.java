package meetingScheduler.Person;

import meetingScheduler.Entity.MeetingRoom;

public interface Subscriber {
    void notifySubscriber(MeetingRoom meetingRoom);    
}