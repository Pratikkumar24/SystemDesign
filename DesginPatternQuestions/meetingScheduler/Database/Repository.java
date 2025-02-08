package SystemDesign.DesginPatternQuestions.meetingScheduler.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.User;

public class Repository {
    HashMap<int[], ArrayList<MeetingRoom>> meetingRooms;
    HashMap<String, User> emailToUsers;
    ArrayList<MeetingRoom> meetingRoomList;
    HashMap<Integer, Boolean> userIds;
    Random random;
    public static Repository instances;

    private Repository() {
        userIds = new HashMap<>();
        meetingRooms = new HashMap<>();
        emailToUsers = new HashMap<>();
        meetingRoomList = new ArrayList<>();
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

    public int getNewUserId() {
        int id = 0;
        do {
            id = random.nextInt(100)+1;
        } while(userIds.containsKey(id));
        return id;
    }

    public List<MeetingRoom> getAvailableMeetingRooms(HashSet<Integer> bookedMeetingRoomIds) {
        List<MeetingRoom> availableMeetingRooms = new ArrayList<>();
        for(MeetingRoom meetingRoom: meetingRoomList) {
            if(!bookedMeetingRoomIds.contains(meetingRoom.getMeetingId())) {
                availableMeetingRooms.add(meetingRoom);
            }
        }
        return availableMeetingRooms;
        
    }

    public HashMap<int[], ArrayList<MeetingRoom>> getMeetingRooms() {
        return meetingRooms;
    }

    public MeetingRoom getMeetingRoomWithId(int id) {
        for(MeetingRoom meetingRoom: meetingRoomList) {
            if(meetingRoom.getMeetingId() == id) {
                return meetingRoom;
            }
        }
        return null;
    }

    public ArrayList<MeetingRoom> getBookedMeetingRoomsByTime(int data, int time) {
        return meetingRooms.get(new int[]{data, time});
    }
    public ArrayList<MeetingRoom> getMeetingRoomList() {
        return meetingRoomList;
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
        meetingRoomList.add(meetingRoom);
    }

    public boolean deleteMeetingRoom(int id) {
        for(MeetingRoom meetingRoom: meetingRoomList) {
            if(meetingRoom.getMeetingId() == id) {
                meetingRoomList.remove(meetingRoom);
                return true;
            }
        }
        return false;
    }

    public MeetingRoom getMeetingRoom(HashSet<Integer> bookedMeetingRoomIds) {
        if(!bookedMeetingRoomIds.isEmpty() && !meetingRoomList.isEmpty()) {
            return meetingRoomList.getFirst();
        }
        for(MeetingRoom meetingRoom: meetingRoomList) {
            if(!bookedMeetingRoomIds.contains(meetingRoom.getMeetingId())) {
                return meetingRoom;
            }
        }
        return null;   
    }

    public int generateId() {
        int id = 0;
        do {
            id = random.nextInt(10)+1;
        } while(isMeetingIdPresent(id));
        return id;
    }

    public boolean isMeetingIdPresent(int id) {
        for(MeetingRoom meetingRoom: meetingRoomList) {
            if(meetingRoom.getMeetingId() == id) {
                return true;
            }
        }
        return false;
    }
}
