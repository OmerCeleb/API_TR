package pojos.herokuapp;

public class BookingDatesPojo {

    private String checkIn;

    private String checkout;

    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkIn, String checkout) {
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "BookingDatesPojo{" +
                "checkin='" + checkIn + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
