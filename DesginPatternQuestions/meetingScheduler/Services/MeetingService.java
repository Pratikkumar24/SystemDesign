package SystemDesign.DesginPatternQuestions.meetingScheduler.Services;

import java.util.ArrayList;
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
        MeetingRoom meetingRoom = searchStrategy.findMeetingRoom(date, startTime, endTime);

        //step 2: book the meeting room
        boolean isBooked = meetingRoom.bookMeeting();
        if(isBooked) {
            meetingRoom.setMeetingRoom("Meeting Room 1");
        } else {
            System.out.println("No Meeting room found");
            return null;
        }

        //step 3: notify the users
        notifyAll(emails, meetingRoom);

        return meetingRoom;
    }

    public void setSearchStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
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
