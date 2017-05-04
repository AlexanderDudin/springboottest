package concert.dto;

/**
 * Created by dudin on 03/05/17.
 */
public class ConcertInfo {
    public String getCustomerData() {
        return customerData;
    }

    public int getConcertId() {
        return concertId;
    }

    public int getCountTickets() {
        return countTickets;
    }

    public void setCustomerData(String customerData) {
        this.customerData = customerData;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    private String customerData;
    private int concertId;
    private int countTickets;
}
