package meetingScheduler.Services.NotificationService;

import java.util.ArrayList;
import java.util.List;

import meetingScheduler.Entity.MeetingRoom;

import meetingScheduler.Person.Subscriber;

public class NotifyService implements Server {
    MeetingRoom meetingRoom;
    List<Subscriber> subscribers = new ArrayList<>();

    public NotifyService(MeetingRoom meetingRoom, List<Subscriber> subscribers) {
        this.meetingRoom = meetingRoom;
        this.subscribers = subscribers;
    }

    @Override
    public void notifySubscriber() {
        System.out.println("Notifying all the subscribers");
        for (Subscriber subscriber : subscribers) {
            subscriber.notifySubscriber(this.meetingRoom);
        }
    }
}
