package concert.dto;

/**
 * Created by dudin on 27/04/17.
 */
public class Reservation {
    public int getReservationId() {
        return reservationId;
    }

    public String getCustomerData() {
        return customerData;
    }

    public int getConcertId() {
        return concertId;
    }

    public int getCountTickets() {
        return countTickets;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
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

    private int reservationId;
    private String customerData;
    private int concertId;
    private int countTickets;

    public Reservation() {
    }

    public Reservation(String customerData, int concertId, int countTickets) {
        this.reservationId = reservationId;
        this.concertId = concertId;
        this.customerData = customerData;
        this.countTickets = countTickets;
    }


}
