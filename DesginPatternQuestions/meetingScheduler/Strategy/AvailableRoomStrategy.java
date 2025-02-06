package SystemDesign.DesginPatternQuestions.meetingScheduler.Strategy;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;

public class AvailableRoomStrategy implements SearchStrategy {

    public Repository repository;
    public AvailableRoomStrategy(Repository repository) {
        this.repository = repository;   
    }

    @Override
    public MeetingRoom findMeetingRoom(int date, int startTime, int endTime) {
        // assume this gives a proper meeting room
        return new MeetingRoom(1, 5, startTime, endTime);
    }
}
