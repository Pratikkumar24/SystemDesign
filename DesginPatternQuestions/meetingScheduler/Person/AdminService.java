package SystemDesign.DesginPatternQuestions.meetingScheduler.Person;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;

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
    
    public void createUser(String email, int userId) {
        User client = new Client(email, userId);
        repository.updatedEmailToUsers(email, client);
    }

    public void createMeetingRoom(String roomName, int capacity) {
        int id = repository.generateId();
        MeetingRoom meetingRoom = new MeetingRoom(id, capacity, 0,0);
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
}
