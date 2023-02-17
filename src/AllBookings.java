import java.util.ArrayList;
import java.util.List;

/**
 * this is a singleton class
 * there is only one booking collection that contains all the bookings
 */
public class AllBookings {
    private AllBookings(){

    }

    private static AllBookings instance = new AllBookings();

    public static AllBookings getInstance(){
        return instance;
    }

    List<Booking> Bookings = new ArrayList<>();
}
