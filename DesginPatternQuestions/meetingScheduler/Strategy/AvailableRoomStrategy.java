package SystemDesign.DesginPatternQuestions.meetingScheduler.Strategy;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;

import java.util.ArrayList;
import java.util.HashSet;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;

public class AvailableRoomStrategy implements SearchStrategy {

    public Repository repository;
    public AvailableRoomStrategy(Repository repository) {
        this.repository = repository;   
    }

    @Override
    public MeetingRoom findMeetingRoom(int date, int startTime, int endTime) {

        HashSet<Integer> bookedMeetingRoomIds = new HashSet<>();
        
        for(int time = startTime; time<=endTime; time++) {
            ArrayList<MeetingRoom> meetingRooms = repository.getMeetingRooms().get(new int[]{date, time});
            if(meetingRooms != null) {
                for(MeetingRoom meetingRoom: meetingRooms) {
                    bookedMeetingRoomIds.add(meetingRoom.getMeetingId());
                }
            }
        }
        System.out.println("Meeting rooms found between "+startTime+" - "+endTime+" -> "+bookedMeetingRoomIds.size());
        MeetingRoom meetingRoom =  repository.getMeetingRoom(bookedMeetingRoomIds);

        if(meetingRoom == null) {
            System.out.println("No meeting room found");
            return null;
        }
        meetingRoom.setTimeInterval(startTime, endTime);    
        
        System.out.println("Available meeting room id : "+meetingRoom.getMeetingId());
        return meetingRoom;
    }
}
