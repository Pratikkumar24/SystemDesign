package SystemDesign.DesginPatternQuestions.meetingScheduler;

import java.util.ArrayList;
import java.util.List;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.AdminService;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Services.MeetingService;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Strategy.AvailableRoomStrategy;

public class Main {
    public static void addAllUsers(AdminService admin) {
        admin.createUser("pratik@gmail.com", 1);
        admin.createUser("rahul@gmail.com", 2);
        admin.createUser("john.doe@gmail.com", 3);
        admin.createUser("jane.doe@gmail.com", 4);
        admin.createUser("alice.smith@gmail.com", 5);
        admin.createUser("bob.jones@gmail.com", 6);
        admin.createUser("charlie.brown@gmail.com", 7);
        admin.createUser("david.wilson@gmail.com", 8);
        admin.createUser("eve.davis@gmail.com", 9);
        admin.createUser("frank.miller@gmail.com", 10);
        admin.createUser("grace.lee@gmail.com", 11);
        admin.createUser("henry.moore@gmail.com", 12);
        admin.createUser("irene.taylor@gmail.com", 13);
        admin.createUser("jack.anderson@gmail.com", 14);
        admin.createUser("karen.thomas@gmail.com", 15);
        admin.createUser("larry.jackson@gmail.com", 16);
        admin.createUser("mary.white@gmail.com", 17);
        admin.createUser("nancy.harris@gmail.com", 18);
        admin.createUser("oliver.martin@gmail.com", 19);
        admin.createUser("paul.thompson@gmail.com", 20);
        admin.createUser("quincy.garcia@gmail.com", 21);
        admin.createUser("rachel.martinez@gmail.com", 22);
    }
    public static void main(String[] args) {
        AdminService admin = AdminService.getInstance();
        //initialize the users to database
        addAllUsers(admin);

        MeetingService meetingService = MeetingService.getInstance();
        meetingService.setSearchStrategy(new AvailableRoomStrategy(Repository.getInstance()));

        List<String> emails = new ArrayList<>();
        emails.add("pratik@gmail.com");
        emails.add("rahul@gmail.com");
        emails.add("john.doe@gmail.com");
        MeetingRoom meetingRoom = meetingService.getMeetingRoom(1, 12, 15, emails);
        System.out.println("Meeting Room: " + meetingRoom.getMeetingRoomName());

        List<String> emails2 = new ArrayList<>();
        emails2.add("jane.doe@gmail.com");
        emails2.add("alice.smith@gmail.com");
        emails2.add("bob.jones@gmail.com");
        MeetingRoom meetingRoom2 = meetingService.getMeetingRoom(2, 14, 16, emails2);
        System.out.println("Meeting Room: " + meetingRoom2.getMeetingRoomName());
    }
}
