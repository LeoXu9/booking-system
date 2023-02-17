/**
 * this is an interface for event that could be either online or in person
 */
public interface Event {
    /**
     * tickets left is reduced as customers make bookings
     *
     * @param num the number of tickets purchased by customer
     */
    void sellTickets(int num);

    /**
     * checks if the event has no tickets left
     *
     * @return true if there is still tickets left, false if not
     */
    boolean isNotSoldOut();
}
