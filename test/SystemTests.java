import org.junit.jupiter.api.*;
import java.util.Date;

public class SystemTests {
    @org.junit.jupiter.api.Test
    void test01ScheduleEvent() throws InterruptedException {
        Booking booking = new Booking();
        AllBookings allBookings = AllBookings.getInstance();
        Schedule schedule = Schedule.getInstance();
        Organiser organiser = new Organiser();
        organiser.recordVenue(schedule, "AStreet", "Beat2", 15);
        Date dt1= new Date();
        Thread.sleep(5*60*10);
        Date dt2 = new Date();
        organiser.recordOnlineEvent(schedule,"event1","comedy", "adults only", "festivalA", "good movie", "Allie", 2, dt1, dt2);
        organiser.recordOnlineEvent(schedule,"event2","comedy", "adults only", "festivalA", "good movie", "Allie", 2, dt1, dt2);
        organiser.recordInPersonEvent(schedule, "event3", "theatre", "general audience", "fes", "very good", "lady gaga", 3, 1000,dt1, dt2);
        organiser.recordInPersonEvent(schedule, "event4", "theatre", "general audience", "fes", "very good", "lady gaga", 3, 1000,dt1, dt2);
        Assertions.assertNotEquals(schedule.onlineEvents.get(0), schedule.onlineEvents.get(1));
    }

    @Test
    void test02BookEvent() throws InterruptedException {
        Booking booking = new Booking();
        AllBookings allBookings = AllBookings.getInstance();
        Schedule schedule = Schedule.getInstance();
        Organiser organiser = new Organiser();
        organiser.recordVenue(schedule, "AStreet", "Beat2", 15);
        Date dt1= new Date();
        Thread.sleep(5*60*10);
        Date dt2 = new Date();
        organiser.recordOnlineEvent(schedule,"event1","comedy", "adults only", "festivalA", "good movie", "Allie", 2, dt2, dt1);
        organiser.recordOnlineEvent(schedule,"event2","comedy", "adults only", "festivalA", "good movie", "Allie", 2, dt2, dt1);
        organiser.recordInPersonEvent(schedule, "event3", "theatre", "general audience", "fes", "very good", "lady gaga", 3, 1000,dt1, dt2);
        organiser.recordInPersonEvent(schedule, "event4", "theatre", "general audience", "fes", "very good", "lady gaga", 3, 1000,dt1, dt2);
        booking.startBookingOnlineEvent(schedule.onlineEvents.get(0), 3, "Asdfg", "Aoinpq", "dasdasd", "asd@123.com", "+44-1231231233");
    }
}
