package pojos.herokuapp;

public class BookingPojo {

    private String firstname;

    private String lastname;

    private Integer totalprice;

    private Boolean depositpaid;

    private BookingDatesPojo bookingDatesPojo;

    private String additionalneeds;

    public BookingPojo() {
    }

    public BookingPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDatesPojo bookingDatesPojo, String additionalneeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingDatesPojo = bookingDatesPojo;
        this.additionalneeds = additionalneeds;
    }



    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public BookingDatesPojo getBookingDatesPojo() {
        return bookingDatesPojo;
    }

    public void setBookingDatesPojo(BookingDatesPojo bookingDatesPojo) {
        this.bookingDatesPojo = bookingDatesPojo;
    }

    public String getAdditionalneeds() {
        return additionalneeds;
    }

    public void setAdditionalneeds(String additionalneeds) {
        this.additionalneeds = additionalneeds;
    }

    @Override
    public String toString() {
        return "BookingPojo{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingDatesPojo=" + bookingDatesPojo +
                ", additionalneeds='" + additionalneeds + '\'' +
                '}';
    }
}
