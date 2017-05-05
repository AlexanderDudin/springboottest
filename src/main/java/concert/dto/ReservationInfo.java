package concert.dto;

import java.time.LocalDate;

/**
 * Created by dudin on 04/05/17.
 */
public class ReservationInfo {


    public String getPerformer() {
        return performer;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getSpendingTime() {
        return spendingTime;
    }

    public int getCountTickets() {
        return countTickets;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setSpendingTime(LocalDate spendingTime) {
        this.spendingTime = spendingTime;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    public void setCustomerFname(final String customerFname) {
        this.customerFname = customerFname;
    }

    public void setCustomerPhone(final String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public ReservationInfo(final String customerFname, final String customerPhone, final String performer, final String location, final LocalDate spendingTime, final int countTickets) {
        this.customerFname = customerFname;
        this.customerPhone = customerPhone;
        this.performer = performer;
        this.location = location;
        this.spendingTime = spendingTime;
        this.countTickets = countTickets;
    }

    private String customerFname;
    private String customerPhone;
    private String performer;
    private String location;
    private LocalDate spendingTime;
    private int countTickets;

}
