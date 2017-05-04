package concert.controller;

import concert.dao.OnlineConcertDao;
import concert.dto.Concert;
import concert.dto.ConcertInfo;
import concert.dto.Reservation;
import concert.dto.ReservationInfo;
import concert.dto.Responce.CancellationResponse;
import concert.dto.Responce.ReservationInfoResponce;
import concert.dto.Responce.ReservationResponse;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;


/**
 * Created by dudin on 29/04/17.
 */
@RestController
@RequestMapping("/concert")
@ComponentScan(basePackages = {"concert.dao"})
public class ConcertController {
    @Inject
    private OnlineConcertDao onlineConcertDao;


    @RequestMapping(value = "/schedule", method = RequestMethod.GET)
    public List<Concert> greeting() {
        return onlineConcertDao.getSchedule();
    }

    @RequestMapping(value = "/booking", method = RequestMethod.POST)
    public ReservationResponse reserve(@RequestBody ConcertInfo input) {
        ReservationResponse response = new ReservationResponse();
        String errorMessage = null;
        int concertId = input.getConcertId();
        boolean flag = false;
        //String reservationCode = null;
        if (concertId > 0) {
            onlineConcertDao.addReservation(new Reservation(input.getCustomerData(), input.getConcertId(), input.getCountTickets()));
            flag = true;

        }

        if (flag == false) {
            errorMessage = String.format("%s", "Wrong id");
        }
        response.setReservationCode(concertId);
        response.setErrorMessage(errorMessage);
        return response;
    }

    @RequestMapping(value = "/mybooking", method = {RequestMethod.GET})
    public ReservationInfoResponce getReservationInfo(@RequestParam final int reservationCode) {
        final ReservationInfoResponce response = new ReservationInfoResponce();
        boolean isReservationReal = false;
        String errorMessage = null;
        final ReservationInfo reservationInfo = onlineConcertDao.getReservationInfo(reservationCode);
        if (reservationInfo != null) {
            response.setReservationInfo(reservationInfo);
            response.setErrorMessage(null);
            isReservationReal = true;
        }
        if (!isReservationReal) {
            errorMessage = String.format("%s", "Wrong id");
            response.setErrorMessage(errorMessage);
        }
        return response;
    }


    @RequestMapping(value = "/mybooking/cancel", method = {RequestMethod.GET, RequestMethod.DELETE})
    public CancellationResponse cancelReservation(@RequestParam final int bookingCode) {
        CancellationResponse response = new CancellationResponse();
        String errorMessage = null;
        boolean isReservationCanceled = false;
        isReservationCanceled = onlineConcertDao.deleteBooking(bookingCode);

        if (!isReservationCanceled) {
            errorMessage = String.format("%s %d", "Wrong id ", bookingCode);
        }
        response.setErrorMessage(errorMessage);
        return response;
    }

}
