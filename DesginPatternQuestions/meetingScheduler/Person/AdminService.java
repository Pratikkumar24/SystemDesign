package meetingScheduler.Person;

import java.util.List;

import meetingScheduler.Database.Repository;
import meetingScheduler.Entity.MeetingRoom;

public class AdminService {

    private static Repository repository = Repository.getInstance();
    private static AdminService adminService;

    private AdminService() {
    }
    public static AdminService getInstance() {
        if(adminService == null) {
            synchronized(AdminService.class) {
                if(adminService == null) {
                    adminService = new AdminService();
                }
            }
        }
        return adminService;
    }
    
    public void createUser(String email) {
        if(repository.getUserByEmail(email) != null) {
            System.out.println("User already exists");
            return;
        }
        int userId = repository.getNewUserId();
        User client = new Client(email, userId);
        repository.updatedEmailToUsers(email, client);
    }

    public void createMeetingRoom(int capacity) {
        int id = repository.generateId();
        MeetingRoom meetingRoom = new MeetingRoom(id, capacity);
        repository.updateMeetingRoom(meetingRoom);
    }

    public void deleteMeetingRoom(int id) {
       boolean isDeleted = repository.deleteMeetingRoom(id);
        if(!isDeleted) {
            System.out.println("Meeting room not found");
        } else {
            System.out.println("Meeting room deleted successfully");
        }
    }

    public List<MeetingRoom> getUsersSchedule(String email) {
        User user = repository.getUserByEmail(email);
        if(user == null) {
            System.out.println("User not found");
            return null;
        }
        return user.getMeetingRooms();
    }

    public User getUser(String email) {
        return repository.getUserByEmail(email);
    }
}
