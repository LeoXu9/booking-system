import java.util.ArrayList;
import java.util.List;

/**
 * this is a singleton class
 * there is only one schedule that contains collections of venues,
 * online events, in person events and performers
 */
public class Schedule {
    private Schedule(){

    }

    private static Schedule instance = new Schedule();

    public static Schedule getInstance(){
        return instance;
    }
    List<Venue> venues = new ArrayList<>();
    List<OnlineEvent> onlineEvents = new ArrayList<>();
    List<InPersonEvent> inPersonEvents = new ArrayList<>();
    List<String> performers = new ArrayList<>();
}
