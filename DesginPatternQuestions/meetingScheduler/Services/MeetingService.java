package SystemDesign.DesginPatternQuestions.meetingScheduler.Services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Person.Subscriber;

import SystemDesign.DesginPatternQuestions.meetingScheduler.Entity.MeetingRoom;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Database.Repository;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Services.NotificationService.NotifyService;
import SystemDesign.DesginPatternQuestions.meetingScheduler.Strategy.SearchStrategy;

public class MeetingService {
    public static MeetingService meetingService;
    public SearchStrategy searchStrategy;
    public Repository repository;
    public NotifyService notifyService;

    private MeetingService() {
        repository = Repository.getInstance();
    }

    public static MeetingService getInstance() {
        if(meetingService == null) {
            synchronized(MeetingService.class) {
                if(meetingService == null) {
                    meetingService = new MeetingService();
                }
            }
        }
        return meetingService;
    }

    public MeetingRoom getMeetingRoom(int date, int startTime, int endTime, List<String> emails) {
        //step 1: search for the meeting room based on the strategy
        System.out.println("Searching for the meeting room");
        MeetingRoom meetingRoom = searchStrategy.findMeetingRoom(date, startTime, endTime);
        if(meetingRoom == null) {
            return null;
        }

        //step 2: book the meeting room
        boolean isBooked = meetingRoom.bookMeeting();
        if(!isBooked) {
            return null;
        }

        //step 3: notify the users
        notifyAll(emails, meetingRoom);

        return meetingRoom;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }
    public List<MeetingRoom> getOccupiedMeetingRoom(int date, int startTime, int endTime) {
        HashSet<Integer> bookedMeetingRoomIds = new HashSet<>();
        
        for(int time = startTime; time<=endTime; time++) {
            ArrayList<MeetingRoom> meetingRooms = repository.getMeetingRooms().get(new int[]{date, time});
            if(meetingRooms != null) {
                for(MeetingRoom meetingRoom: meetingRooms) {
                    bookedMeetingRoomIds.add(meetingRoom.getMeetingId());
                }
            }
        }
        List<MeetingRoom> occupiedList = new ArrayList<>();
        for(Integer ids: bookedMeetingRoomIds) {
            MeetingRoom  room = repository.getMeetingRoomWithId(ids);
            if(room!=null)
                occupiedList.add(room);
            else {
                System.out.println("Could'nt find room for id:"+ids);
            }
        }
        return occupiedList;
    }
    public List<MeetingRoom> getAvailableMeetingRooms(int date, int startTime, int endTime) {
        HashSet<Integer> bookedMeetingRoomIds = new HashSet<>();
        
        for(int time = startTime; time<=endTime; time++) {
            ArrayList<MeetingRoom> meetingRooms = repository.getMeetingRooms().get(new int[]{date, time});
            if(meetingRooms != null) {
                for(MeetingRoom meetingRoom: meetingRooms) {
                    bookedMeetingRoomIds.add(meetingRoom.getMeetingId());
                }
            }
        }
        System.out.println("Number of meeting rooms booked between "+startTime+" to "+endTime+" -> "+bookedMeetingRoomIds.size());
        List<MeetingRoom> availableMeetingRooms = repository.getAvailableMeetingRooms(bookedMeetingRoomIds);
        return availableMeetingRooms;
    }

    public void notifyAll(List<String> emails, MeetingRoom meetingRoom) {
        List<Subscriber> subscribers = new ArrayList<>();
        for(String email: emails) {
            Subscriber subscriber = repository.getUserByEmail(email);
            if(subscriber != null) {
                subscribers.add(subscriber);
            }
        }
        notifyService = new NotifyService(meetingRoom, subscribers);
        
        notifyService.notifySubscriber();
    }
}
