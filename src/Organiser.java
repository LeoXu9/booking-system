import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class provides methods for the organisers to record venues, performers and events
 */
public class Organiser {

    /**
     * organiser is able to record a venue with its details
     *
     * @param schedule the schedule contains a collection of venues
     * @param name the name of the venue
     * @param address the name of the address
     * @param capacity number of people that the venue can hold
     */
    public void recordVenue(Schedule schedule, String name, String address, int capacity) {
        if (capacity > 0) {
            Venue venue = new Venue(name, address, capacity);
            schedule.venues.add(venue);
        }
    }

    /**
     * organiser is able to record performers with their names
     *
     * @param performerNames the names of the performers
     * @param schedule the schedule contains a collection of performers
     */
    public void recordPerformer(String performerNames, Schedule schedule) {
        schedule.performers.add(performerNames);
    }

    /**
     * checks if one duration overlaps with another one
     *
     * @param startTime1 start time of the first duration
     * @param endTime1 end time of the first duration
     * @param startTime2 start time of the second duration
     * @param endTime2 end time of the second duration
     * @return true if the durations overlap
     */
    public static boolean isOverlapping(Date startTime1, Date endTime1, Date startTime2, Date endTime2) {
        return startTime1.before(endTime2) && startTime2.before(endTime1);
    }

    /**
     * Checks eligibility of the event, then create new instance, and add to the collection of events
     *
     * @param schedule the schedule contains a collection of events
     * @param eventName the name of the event
     * @param genre the genre of the event
     * @param suitability the suitability of the event
     * @param festival the festival that the event belongs to
     * @param description the description of the event
     * @param performer the performer of the event
     * @param price the price that customers to pay
     * @param startTime the start time of the event
     * @param endTime the end time of the event
     */
    public void recordOnlineEvent(Schedule schedule, String eventName, String genre, String suitability, String festival, String description, String performer, int price, Date startTime, Date endTime) {
        if(isEligibleOnlineEvent(schedule, genre, suitability, festival, startTime, endTime)){
            OnlineEvent onlineEvent = new OnlineEvent(schedule, eventName, genre, suitability, festival, description, performer, price, startTime, endTime);
            schedule.onlineEvents.add(onlineEvent);
        }
    }

    /**
     * checks eligibility of the event details
     *
     * @param schedule the schedule contains a collection of events
     * @param genre the genre of the event
     * @param suitability the suitability of the event
     * @param festival the festival that the event belongs to
     * @param startTime the start time of the event
     * @param endTime the end time of the event
     * @return true if the details are all eligible
     */
    public boolean isEligibleOnlineEvent(Schedule schedule, String genre, String suitability, String festival, Date startTime, Date endTime){
        assert(genre.equals("comedy")||genre.equals("variety")||genre.equals("theatre")||genre.equals("music")||genre.equals("children's"));
        assert(suitability.equals("general audience")||suitability.equals("adults only"));
        for(OnlineEvent event:schedule.onlineEvents){
            if(event.getFestival().equals(festival)) {
                Date startTime1 = event.getStartTime();
                Date endTime1 = event.getEndTime();
                if(isOverlapping(startTime1, endTime1, startTime, endTime)){
                    break;
                }
            }
        }
        return true;
    }

    /**
     * Checks eligibility of the event, then create new instance, and add to the collection of events
     *
     * @param schedule the schedule contains a collection of events
     * @param eventName the name of the event
     * @param genre the genre of the event
     * @param suitability the suitability of the event
     * @param festival the festival that the event belongs to
     * @param description the description of the event
     * @param performer the performer of the event
     * @param price the price that customers to pay
     * @param startTime the start time of the event
     * @param endTime the end time of the event
     */
    public void recordInPersonEvent(Schedule schedule, String eventName, String genre, String suitability, String festival, String description, String performer, int price, int capacity, Date startTime, Date endTime) {
        Venue chosenVenue = isEligibleInPersonEvent(schedule, genre, suitability, festival, startTime, endTime);
        if(chosenVenue!=null){
            InPersonEvent inPersonEvent = new InPersonEvent(schedule, eventName, genre, suitability, festival, description, performer, price, chosenVenue, capacity, startTime, endTime);
            schedule.inPersonEvents.add(inPersonEvent);
        }

    }

    /**
     * checks eligibility of the event details
     *
     * @param schedule the schedule contains a collection of events
     * @param genre the genre of the event
     * @param suitability the suitability of the event
     * @param festival the festival that the event belongs to
     * @param startTime the start time of the event
     * @param endTime the end time of the event
     * @return true if the details are all eligible
     */
    public Venue isEligibleInPersonEvent(Schedule schedule, String genre, String suitability, String festival, Date startTime, Date endTime){
        assert(genre.equals("comedy")||genre.equals("variety")||genre.equals("theatre")||genre.equals("music")||genre.equals("children's"));
        assert(suitability.equals("general audience")||suitability.equals("adults only"));
        List<Venue> availableVenues = new ArrayList<>();
        for(Venue venue:schedule.venues){
            boolean OKVenues = true;
            for(int i = 0; i < venue.startDates.size(); i++){
                Date startTime1 = venue.startDates.get(i);
                Date endTime1 = venue.endDates.get(i);
                if(isOverlapping(startTime1, endTime1, startTime, endTime)){
                    OKVenues = false;
                    break;
                }
            }
            if(OKVenues){
                availableVenues.add(venue);
            }
        }
        Venue chosenVenue = null;
        if(availableVenues.size()>0){
            chosenVenue = availableVenues.get(0);
        }
        return chosenVenue;
    }
}
