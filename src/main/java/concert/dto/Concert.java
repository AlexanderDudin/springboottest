package concert.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

/**
 * Created by dudin on 28/04/17.
 */
public class Concert {
    private int concertId;
    private String performer;
    private String location;
    private LocalDate spendingTime;
    private int coastTicket;
    private int amountTicket;

    public int getConcertId() {
        return concertId;
    }

    public String getPerformer() {
        return performer;
    }

    public String getLocation() {
        return location;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public LocalDate getSpendingTime() {
        return spendingTime;
    }

    public int getCoastTicket() {
        return coastTicket;
    }

    public int getAmountTicket() {
        return amountTicket;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
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

    public void setCoastTicket(int coastTicket) {
        this.coastTicket = coastTicket;
    }

    public void setAmountTicket(int amountTicket) {
        this.amountTicket = amountTicket;
    }

    public Concert() {
    }

    public Concert(int concertId, String performer, String location, LocalDate spendingTime, int coastTicket, int amountTicket) {

        this.concertId = concertId;
        this.performer = performer;
        this.location = location;
        this.spendingTime = spendingTime;
        this.coastTicket = coastTicket;
        this.amountTicket = amountTicket;
    }
}
