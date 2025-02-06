package SystemDesign.DesginPatternQuestions.meetingScheduler.Person;

import java.util.ArrayList;
import java.util.List;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;

public class User implements Subscriber{

    String email;
    int userId;
    List<MeetingRoom> meetingRooms;

    public User(String email, int userId) {
        meetingRooms = new ArrayList<>();
        this.email = email;
        this.userId = userId;
    }

    @Override
    public void notifySubscriber(MeetingRoom meetingRoom) {
        meetingRooms.add(meetingRoom);
        System.out.println("Notified user: " + email + " for meeting room: " + meetingRoom.getMeetingRoomName());
    }
    
    public List<MeetingRoom> getMeetingRooms() {
        return meetingRooms;
    }
    //todo - Need to update the meetingRooms
}
