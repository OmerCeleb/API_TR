package pojos.gmibank;

import java.io.Serializable;
import java.util.List;

public class CustomerPojo implements Serializable {

    private int id;

    private String firstName;

    private String lastName;

    private String middleInitial;

    private String email;

    private String mobilePhoneNumber;

    private String zipCode;

    private String address;

    private String city;

    private String ssn;

    private String createData;

    private boolean zelleEnrolled;

    private CountryPojo country;

    private String state;

    private UserPojo user;
    private List<AccountPojo> accounts;


    public CustomerPojo() {
    }

    public CustomerPojo(int id, String firstName, String lastName, String middleInitial, String email, String mobilePhoneNumber, String zipCode, String address, String city, String ssn, String createData, boolean zelleEnrolled, CountryPojo country, String state, UserPojo user, List<AccountPojo> accounts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.email = email;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.zipCode = zipCode;
        this.address = address;
        this.city = city;
        this.ssn = ssn;
        this.createData = createData;
        this.zelleEnrolled = zelleEnrolled;
        this.country = country;
        this.state = state;
        this.user = user;
        this.accounts = accounts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }

    public void setMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getCreateData() {
        return createData;
    }

    public void setCreateData(String createData) {
        this.createData = createData;
    }

    public boolean isZelleEnrolled() {
        return zelleEnrolled;
    }

    public void setZelleEnrolled(boolean zelleEnrolled) {
        this.zelleEnrolled = zelleEnrolled;
    }

    public CountryPojo getCountry() {
        return country;
    }

    public void setCountry(CountryPojo country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public UserPojo getUser() {
        return user;
    }

    public void setUser(UserPojo user) {
        this.user = user;
    }

    public List<AccountPojo> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountPojo> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "CustomerPojo{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleInitial='" + middleInitial + '\'' +
                ", email='" + email + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", ssn='" + ssn + '\'' +
                ", createData='" + createData + '\'' +
                ", zelleEnrolled=" + zelleEnrolled +
                ", country=" + country +
                ", state='" + state + '\'' +
                ", user=" + user +
                ", accounts=" + accounts +
                '}';
    }
}
