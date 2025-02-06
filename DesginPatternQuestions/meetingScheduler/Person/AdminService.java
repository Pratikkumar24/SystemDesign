package SystemDesign.DesginPatternQuestions.meetingScheduler.Person;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;

public class AdminService{

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
}
