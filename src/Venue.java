import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * this class contains attributes of venue,
 * and the constructor and getter methods
 */
public class Venue {

    /**
     * Details of a venue
     */
    private final String name;
    private final String address;
    private final int capacity;

    /**
     * collection of the unavailable of a venue
     */
    List<Date> startDates = new ArrayList<>();
    List<Date> endDates = new ArrayList<>();

    /**
     * constructor method with name, address and capacity
     *
     * @param name the name of the venue
     * @param address the address of the venue
     * @param capacity the capacity of the venue
     */
    public Venue(String name, String address, int capacity) {
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCapacity() {
        return capacity;
    }
}
