package SystemDesign.DesginPatternQuestions.meetingScheduler.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.User;

public class Repository {
    HashMap<int[], ArrayList<MeetingRoom>> meetingRooms;
    HashMap<String, User> emailToUsers;
    ArrayList<MeetingRoom> meetingRoomSet;
    Random random;
    public static Repository instances;

    private Repository() {
        meetingRooms = new HashMap<>();
        emailToUsers = new HashMap<>();
        meetingRoomSet = new ArrayList<>();
        random = new Random();
    }

    public static Repository getInstance() {
        if(instances == null) {
            synchronized(Repository.class) {
                if(instances == null) {
                    instances = new Repository();
                }
            }
        }
        return instances;
    }

    public HashMap<int[], ArrayList<MeetingRoom>> getMeetingRooms() {
        return meetingRooms;
    }
    public void updatedEmailToUsers(String email, User user) {
        emailToUsers.put(email, user);
    }
    public HashMap<String, User> getEmailToUsers() {
        return emailToUsers;
    }

    public User getUserByEmail(String email) {
        return emailToUsers.get(email);
    }

    public void updateMeetingRoom(MeetingRoom meetingRoom) {
        meetingRoomSet.add(meetingRoom);
    }

    public boolean deleteMeetingRoom(int id) {
        for(MeetingRoom meetingRoom: meetingRoomSet) {
            if(meetingRoom.getMeetingId() == id) {
                meetingRoomSet.remove(meetingRoom);
                return true;
            }
        }
        return false;
    }

    public Integer getMeetingRoom(HashSet<Integer> bookedMeetingRoomIds) {
        for(MeetingRoom meetingRoom: meetingRoomSet) {
            if(!bookedMeetingRoomIds.contains(meetingRoom.getMeetingId())) {
                return meetingRoom.getMeetingId();
            }
        }
        return -1;   
    }

    public int generateId() {
        int id = 0;
        do {
            id = random.nextInt(10);
        } while(!isMeetingIdPresent(id));
        return id;
    }

    public boolean isMeetingIdPresent(int id) {
        for(MeetingRoom meetingRoom: meetingRoomSet) {
            if(meetingRoom.getMeetingId() == id) {
                return true;
            }
        }
        return false;
    }
}
