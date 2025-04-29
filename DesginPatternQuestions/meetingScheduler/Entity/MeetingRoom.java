package meetingScheduler.Entity;

import meetingScheduler.Person.User;

public class MeetingRoom {
    int meetingId;
    String meetingRoom;
    int meetingSize;
    long startTime;
    long endTime;
    User createdBy;
    Boolean isBooked;

    public MeetingRoom(int meetingId, int meetingSize) {
        this.meetingId = meetingId;
        this.meetingSize = meetingSize;
        this.isBooked = false;
        this.meetingRoom = "";
    }

    public int getMeetingId() {
        return meetingId;
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
    public void setTimeInterval(long startTime, long endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long[] getInterval() {
        return new long[]{this.startTime, this.endTime};
    }
    public boolean isBooked() {
        return isBooked;
    }

    public int getCapacity() {
        return this.meetingSize;
    }
}
