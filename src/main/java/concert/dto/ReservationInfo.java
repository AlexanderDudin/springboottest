package concert.dto;

import java.time.LocalDate;

/**
 * Created by dudin on 04/05/17.
 */
public class ReservationInfo {


    public String getCustomerData() {
        return customerData;
    }

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

    public void setCustomerData(String customerData) {
        this.customerData = customerData;
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

    public ReservationInfo(String customerData, String performer, String location, LocalDate spendingTime, int countTickets) {

        this.customerData = customerData;
        this.performer = performer;
        this.location = location;
        this.spendingTime = spendingTime;
        this.countTickets = countTickets;
    }


    private String customerData;
    private String performer;
    private String location;
    private LocalDate spendingTime;
    private int countTickets;

}
