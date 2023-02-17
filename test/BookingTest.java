import org.junit.jupiter.api.*;
import java.util.Date;

class BookingTest {
    @org.junit.jupiter.api.Test
    void test01GenerateBookingNumber() {
        Booking booking1 = new Booking();
        String a = booking1.generateBookingNumber("Claire", "Alexander");
        Assertions.assertNotEquals("CAlexa2021-07-23-13:54:55.130719", a);
        /* this test compares 2 booking numbers with the same name, the timestamps differ them. */
    }

    @org.junit.jupiter.api.Test
    void test02GenerateBookingNumber() {
        Booking booking1 = new Booking();
        String a = booking1.generateBookingNumber("Israel", "Adesanya");
        Assertions.assertNotEquals("CAlexa2021-07-23-13:54:55.130719", a);
        /* this test compares 2 booking numbers that are completely different. */
    }

    @org.junit.jupiter.api.Test
    void test03GenerateBookingNumber() {
        Booking booking1 = new Booking();
        String a = booking1.generateBookingNumber("Michael", "Gnaw");
        Assertions.assertNotEquals("CAlexa2021-07-23-13:54:55.130719", a);
        /* this test compares 2 booking numbers that are completely different. */
    }

    @org.junit.jupiter.api.Test
    void test01Bookable() throws InterruptedException {
        Booking booking = new Booking();
        Date now = new Date();
        Thread.sleep(5*60*10);
        Date now2 = new Date();
        Assertions.assertTrue(booking.bookable(now2, now));
        /* now happens sooner than now2 */
    }

    @org.junit.jupiter.api.Test
    void test02Bookable() throws InterruptedException {
        Booking booking = new Booking();
        Date now = new Date();
        Thread.sleep(5*60*10);
        Date now2 = new Date();
        Assertions.assertFalse(booking.bookable(now, now2));
        /* now happens no sooner than now2 */
    }

    @org.junit.jupiter.api.Test
    void test03Bookable() throws InterruptedException {
        Booking booking = new Booking();
        Date now = new Date();
        long Weeks = System.currentTimeMillis() - (86400 * 7 * 1000);
        Date weekAgo = new Date(Weeks);  //a week ago
        Assertions.assertFalse(booking.bookable(weekAgo, now));
        /* the case where the event has happened a week ago */
    }

    @org.junit.jupiter.api.Test
    void test01ValidName() {
        Booking booking = new Booking();
        Assertions.assertTrue(booking.validName("Adesanya"));
        /* name is legal */
    }

    @org.junit.jupiter.api.Test
    void test02ValidName() {
        Booking booking = new Booking();
        Assertions.assertFalse(booking.validName("ADesanya"));
        /* not legal because second letter is upper case */
    }

    @org.junit.jupiter.api.Test
    void test03ValidName() {
        Booking booking = new Booking();
        Assertions.assertFalse(booking.validName("adesanya"));
        /* not legal because first letter is lower case */
    }

    @org.junit.jupiter.api.Test
    void test01ValidEmailAddress() {
        Booking booking = new Booking();
        Assertions.assertTrue(booking.validEmailAddress("123@okpppp.com"));
        /* legal email address */
    }

    @org.junit.jupiter.api.Test
    void test02ValidEmailAddress() {
        Booking booking = new Booking();
        Assertions.assertTrue(booking.validEmailAddress("123456ii@jj.com"));
        /* legal and longer email address */
    }

    @org.junit.jupiter.api.Test
    void test03ValidEmailAddress() {
        Booking booking = new Booking();
        Assertions.assertFalse(booking.validEmailAddress("123fd.com"));
        /* no "@" thus not legal */
    }

    @org.junit.jupiter.api.Test
    void test01ValidPhoneNumber() {
        Booking booking  = new Booking();
        Assertions.assertTrue(booking.validPhoneNumber("+44-1234554321"));
        /* legal phone number */
    }

    @org.junit.jupiter.api.Test
    void test02ValidPhoneNumber() {
        Booking booking  = new Booking();
        Assertions.assertFalse(booking.validPhoneNumber("44-1234554321"));
        /* not legal because of missing "+" */
    }

    @org.junit.jupiter.api.Test
    void test03ValidPhoneNumber() {
        Booking booking  = new Booking();
        Assertions.assertFalse(booking.validPhoneNumber("+441234554321"));
        /* not legal because of missing "-" */
    }

    @org.junit.jupiter.api.Test
    void pay() {
        Booking booking  = new Booking();
        Assertions.assertTrue(booking.pay());
        /* pay always returns true */
    }
}
