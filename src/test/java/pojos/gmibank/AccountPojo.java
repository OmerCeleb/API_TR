package pojos.gmibank;

import java.io.Serializable;

public class AccountPojo implements Serializable {

    private int id;

    private String description;

    private int balance;

    private String accountType;

    private String accountStatusType;

    private String createDate;

    private String closeDate;

    private Object employee;

    private Object accountLogs;

    public AccountPojo() {
    }

    public AccountPojo(int id, String description, int balance, String accountType, String accountStatusType, String createDate, String closeDate, Object employee, Object accountLogs) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.accountType = accountType;
        this.accountStatusType = accountStatusType;
        this.createDate = createDate;
        this.closeDate = closeDate;
        this.employee = employee;
        this.accountLogs = accountLogs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatusType() {
        return accountStatusType;
    }

    public void setAccountStatusType(String accountStatusType) {
        this.accountStatusType = accountStatusType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public Object getAccountLogs() {
        return accountLogs;
    }

    public void setAccountLogs(Object accountLogs) {
        this.accountLogs = accountLogs;
    }

    @Override
    public String toString() {
        return "AccountPojo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", accountStatusType='" + accountStatusType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", closeDate='" + closeDate + '\'' +
                ", employee=" + employee +
                ", accountLogs=" + accountLogs +
                '}';
    }
}
