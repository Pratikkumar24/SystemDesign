package meetingScheduler.Strategy;

import meetingScheduler.Entity.MeetingRoom;

public interface SearchStrategy {
    MeetingRoom findMeetingRoom(int date, int startTime, int endTime);
}
