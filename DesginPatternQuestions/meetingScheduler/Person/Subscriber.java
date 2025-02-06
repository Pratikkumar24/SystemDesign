package SystemDesign.DesginPatternQuestions.meetingScheduler.Person;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;

public interface Subscriber {
    void notifySubscriber(MeetingRoom meetingRoom);    
}