package meetingScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import meetingScheduler.Database.Repository;
import meetingScheduler.Entity.MeetingRoom;
import meetingScheduler.Person.AdminService;
import meetingScheduler.Person.User;
import meetingScheduler.Services.MeetingService;
import meetingScheduler.Strategy.AvailableRoomStrategy;

public class Main {
    public static void addAllUsers(AdminService admin) {
        admin.createUser("pratik@gmail.com");
        admin.createUser("rahul@gmail.com");
        admin.createUser("john.doe@gmail.com");
        admin.createUser("jane.doe@gmail.com");
        admin.createUser("alice.smith@gmail.com");
        admin.createUser("bob.jones@gmail.com");
        admin.createUser("charlie.brown@gmail.com");
        admin.createUser("david.wilson@gmail.com");
        admin.createUser("eve.davis@gmail.com");
        admin.createUser("frank.miller@gmail.com");
        admin.createUser("grace.lee@gmail.com");
        admin.createUser("henry.moore@gmail.com");
        admin.createUser("irene.taylor@gmail.com");
        admin.createUser("jack.anderson@gmail.com");
        admin.createUser("karen.thomas@gmail.com");
        admin.createUser("larry.jackson@gmail.com");
        admin.createUser("mary.white@gmail.com");
        admin.createUser("nancy.harris@gmail.com");
        admin.createUser("oliver.martin@gmail.com");
        admin.createUser("paul.thompson@gmail.com");
        admin.createUser("quincy.garcia@gmail.com");
        admin.createUser("rachel.martinez@gmail.com");
    }

    public static void addAllMeetingRooms(AdminService admin) {
        admin.createMeetingRoom(4);
        admin.createMeetingRoom(5);
        admin.createMeetingRoom(6);
        admin.createMeetingRoom(4);
        admin.createMeetingRoom(5);
    }
    public static void main(String[] args) {
        AdminService admin = AdminService.getInstance();
        //initialize the users to database
        addAllUsers(admin);
        System.out.println("Created all the users");
        addAllMeetingRooms(admin);
        System.out.println("Created all the meeting rooms");

        Repository repository = Repository.getInstance();
        System.out.println("[+] Total meeting room count: " + repository.getMeetingRoomList().size());

        List<MeetingRoom> meetingRooms = repository.getMeetingRoomList();
        for(MeetingRoom meetingRoom: meetingRooms) {
            System.out.println("[+] Meeting Room: " + meetingRoom.getMeetingId() + " Capacity: " + meetingRoom.getCapacity());
        }

        startbooking(admin, repository);
    }

    public static void printDecisions() {
        System.out.println("======================================");
        System.out.println("1. Book a meeting room");
        System.out.println("2. Check meeting room availability");
        System.out.println("3. Create a meeting room");
        System.out.println("4. Create a user");
        System.out.println("5. Check users availability");
        System.out.println("6. Check occupied meeting rooms");
        System.out.println("7. Exit");
        System.out.println("--------------------------------------");
    }

    public static void startbooking(AdminService admin, Repository repository) {
        System.out.println("--------------------------------------");
        MeetingService meetingService = MeetingService.getInstance();
        meetingService.setSearchStrategy(new AvailableRoomStrategy(repository));

        System.out.println("Please specify what you want-->");
        printDecisions();
        Scanner scanner = new Scanner(System.in);
        int decision = scanner.nextInt();
        do {
            switch(decision) {
                case 1:
                    System.out.println("Enter the date, start time, end time and emails (done to stop)");
                    int date = scanner.nextInt();
                    int startTime = scanner.nextInt();
                    int endTime = scanner.nextInt();
                    List<String> emails = new ArrayList<>();
                    scanner.nextLine();
                    String email = scanner.nextLine();
                    while(!email.equals("done")) {
                        emails.add(email);
                        email = scanner.nextLine();
                    }
                    MeetingRoom meetingRoom = meetingService.getMeetingRoom(date, startTime, endTime, emails);
                    if(meetingRoom == null) {
                        System.out.println("Sorry, no meeting room available");
                    } else {
                        System.out.println("Booked Meeting Room " + meetingRoom.getMeetingId());
                    }
                    break;
                case 2:
                    System.out.println("Enter the date, start time, end time");
                    int date2 = scanner.nextInt();
                    int startTime2 = scanner.nextInt();
                    int endTime2 = scanner.nextInt();
                    List<MeetingRoom> meetingRooms = meetingService.getAvailableMeetingRooms(date2, startTime2, endTime2);
                    if(meetingRooms.isEmpty()) {
                        System.out.println("Sorry, no meeting room available");
                    } else {
                       for(MeetingRoom room: meetingRooms) {
                            System.out.println("Meeting Room " + room.getMeetingId() + " is available");
                       }
                    }
                    break;
                case 3:
                    System.out.println("Enter the capacity of the meeting room");
                    int capacity = scanner.nextInt();
                    admin.createMeetingRoom(capacity);
                    System.out.println("[+] Meeting room created successfully");
                    break;
                case 4:
                    System.out.println("Enter the email of the user");
                    scanner.nextLine();
                    String userEmail = scanner.nextLine();
                    admin.createUser(userEmail);
                    System.out.println("[+] User created successfully");
                    break;
                case 5:
                    System.out.println("Enter email id:");
                    scanner.nextLine();
                    String userEmai2 = scanner.nextLine();
                    User user = admin.getUser(userEmai2);
                    if(user == null) {
                        System.out.println("No user found with this email");
                    } else {
                        List<MeetingRoom> rooms = user.getMeetingRooms();
                        String userName = userEmai2.split("@")[0];
                        if(rooms.isEmpty()) {
                            System.out.println("No meetings scheduled for "+userName);
                        } else {
                            System.out.println("Schedule for " + userName+" is following:");
                            for(MeetingRoom room: rooms) {
                                long[] interval = room.getInterval();
                                System.out.println(" Room Id:"+room.getMeetingId()+" from:"+interval[0]+" hr - "+ interval[1]+" hr");
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter date, starttime, endTime");
                    int date3 = scanner.nextInt();
                    int startTime3 = scanner.nextInt();
                    int endTime3 = scanner.nextInt();

                    List<MeetingRoom> rooms = meetingService.getOccupiedMeetingRoom(date3, startTime3, endTime3);
                    if(rooms.isEmpty()) {
                        System.out.println("No rooms are occupied between "+startTime3+" - "+endTime3);
                    } else {
                        System.out.println("Occupied rooms are:");
                        for(MeetingRoom room: rooms) {
                            System.out.println("Room id:"+room.getMeetingId());
                        }
                    }
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
            
            printDecisions();
            decision = scanner.nextInt();

        } while (decision>=1 && decision<=6);
        
        // List<String> emails = new ArrayList<>();
        // emails.add("pratik@gmail.com");
        // emails.add("rahul@gmail.com");
        // emails.add("john.doe@gmail.com");

        // MeetingRoom meetingRoom = meetingService.getMeetingRoom(1, 12, 15, emails);
        // if(meetingRoom == null) {
        //     System.out.println("Sorry, no meeting room available");
        // } else {
        //     System.out.println("Booked Meeting Room " + meetingRoom.getMeetingId());
        // }

        // // List<String> emails2 = new ArrayList<>();
        // // emails2.add("jane.doe@gmail.com");
        // // emails2.add("alice.smith@gmail.com");
        // // emails2.add("bob.jones@gmail.com");
        // // MeetingRoom meetingRoom2 = meetingService.getMeetingRoom(2, 14, 16, emails2);
        // // if(meetingRoom == null) {
        // //     System.out.println("Sorry, no meeting room available");
        // // } else {
        // //     System.out.println("Booked Meeting Room " + meetingRoom.getMeetingId());
        // // }

        scanner.close();
    }
}
