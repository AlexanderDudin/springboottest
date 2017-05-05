package concert.dto;

/**
 * Created by dudin on 03/05/17.
 */
public class ConcertInfo {


    public int getConcertId() {
        return concertId;
    }

    public int getCountTickets() {
        return countTickets;
    }


    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public void setCountTickets(int countTickets) {
        this.countTickets = countTickets;
    }

    public String getCustomerFname() {
        return customerFname;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerFname(final String customerFname) {
        this.customerFname = customerFname;
    }

    public void setCustomerPhone(final String customerPhone) {
        this.customerPhone = customerPhone;
    }

    private String customerFname;
    private String customerPhone;
    private int concertId;
    private int countTickets;
}
