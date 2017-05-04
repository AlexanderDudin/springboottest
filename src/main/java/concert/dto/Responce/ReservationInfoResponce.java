package concert.dto.Responce;

import concert.dto.ReservationInfo;

/**
 * Created by dudin on 04/05/17.
 */
public class ReservationInfoResponce extends Response {
    public void setReservationInfo(ReservationInfo reservationInfo) {
        this.reservationInfo = reservationInfo;
    }

    public ReservationInfo getReservationInfo() {
        return reservationInfo;
    }

    private ReservationInfo reservationInfo;
}
