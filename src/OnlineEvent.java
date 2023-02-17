import java.util.Date;

/**
 * this class is an implementation of the interface Event,
 * contains attributes of an online event,
 * and provides constructor and getter methods
 */

public class OnlineEvent implements Event{

    /**
     * Details of the online event
     */
    private final String eventName;
    private final String genre;
    private final String suitability;
    private final String festival;
    private final String description;
    private final String performer;
    private final int price;
    private final Date startTime;
    private final Date endTime;

    /**
     * number of tickets that are still available
     */
    private int ticketsLeft = 100;


    /**
     * constructor method for an in person event
     *
     * @param schedule schedule that will include this event
     * @param eventName name of the in person event
     * @param genre genre of the event
     * @param suitability suitability of the event
     * @param festival the festival that this event belongs to
     * @param description the description of the event
     * @param performer the performer of the event
     * @param price the price that the customers pay for a ticket
     * @param startTime the start time of the event
     * @param endTime the end time of the event
     */
    public OnlineEvent(Schedule schedule, String eventName, String genre, String suitability, String festival, String description, String performer, int price, Date startTime, Date endTime) {
        this.eventName = eventName;
        this.genre = genre;
        this.suitability = suitability;
        this.festival = festival;
        this.description = description;
        this.performer = performer;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        System.out.println("In person event constructed.");
    }

    public String getEventName() {
        return eventName;
    }

    public String getGenre() {
        return genre;
    }

    public String getSuitability() {
        return suitability;
    }

    public String getFestival() {
        return festival;
    }

    public String getDescription() {
        return description;
    }

    public String getPerformer() {
        return performer;
    }

    public int getPrice() {
        return price;
    }

    public int getTicketsLeft() {
        return ticketsLeft;
    }

    @Override
    public String toString() {
        return "OnlineEvent{" +
                "event name: '" + eventName + '\'' +
                ", genre: '" + genre + '\'' +
                ", suitability: '" + suitability + '\'' +
                ", festival: '" + festival + '\'' +
                ", description: '" + description + '\'' +
                ", performer: '" + performer + '\'' +
                ", price: " + price +
                ", start time: " + startTime +
                ", end time: " + endTime +
                '}';
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    @Override
    public void sellTickets(int num) {
        this.ticketsLeft -= num;
    }

    @Override
    public boolean isNotSoldOut() {
        return this.ticketsLeft != 0;
    }
}
