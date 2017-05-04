package concert.dto.Responce;

/**
 * Created by Tory on 24.04.2017.
 */
public class ReservationResponse extends Response {
    private int reservationCode;

    public void setReservationCode(int reservationCode) {
        this.reservationCode = reservationCode;
    }

    public int getReservationCode() {
        return reservationCode;
    }
}
