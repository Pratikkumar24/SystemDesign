package SystemDesign.DesginPatternQuestions.meetingScheduler.Strategy;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;

public interface SearchStrategy {
    MeetingRoom findMeetingRoom(int date, int startTime, int endTime);
}
