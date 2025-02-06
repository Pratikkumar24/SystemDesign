package SystemDesign.DesginPatternQuestions.meetingScheduler.Database;

import java.util.ArrayList;
import java.util.HashMap;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.User;

public class Repository {
    HashMap<int[], ArrayList<MeetingRoom>> meetingRooms;
    HashMap<String, User> emailToUsers;

    public static Repository instances;

    private Repository() {
        meetingRooms = new HashMap<>();
        emailToUsers = new HashMap<>();
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
}
