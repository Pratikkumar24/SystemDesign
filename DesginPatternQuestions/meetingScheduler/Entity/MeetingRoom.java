package SystemDesign.DesginPatternQuestions.meetingScheduler.Entity;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.User;

public class MeetingRoom {
    int meetingId;
    String meetingRoom;
    int meetingSize;
    long startTime;
    long endTime;
    User createdBy;
    Boolean isBooked;

    public MeetingRoom(int meetingId, int meetingSize, long startTime, long endTime) {
        this.meetingId = meetingId;
        this.meetingSize = meetingSize;
        this.startTime = startTime;
        this.endTime = endTime;
        this.isBooked = false;
        this.meetingRoom = "";
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }
    public String getMeetingRoomName() {
        return this.meetingRoom;
    }

    public int getMeetingId() {
        return meetingId;
    }

    public long[] getMeetingTime() {
        return new long[]{this.startTime, this.endTime};
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public boolean bookMeeting() {
        if (isBooked) {
            System.out.println("Meeting room is already booked");
            return false;
        }
        isBooked = true;
        return true;
    }

    public boolean isBooked() {
        return isBooked;
    }
}
