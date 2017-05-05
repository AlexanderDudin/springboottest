package concert.dto;

/**
 * Created by dudin on 27/04/17.
 */
public class Reservation {
    public int getReservationId() {
        return reservationId;
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

    private int reservationId;
    private String customerFname;
    private String customerPhone;
    private int concertId;
    private int countTickets;


    public Reservation() {
    }

    public Reservation(String customerFname, String customerPhone, int concertId, int countTickets) {
        this.customerFname = customerFname;
        this.customerPhone = customerPhone;
        this.concertId = concertId;
        this.countTickets = countTickets;
    }


}
