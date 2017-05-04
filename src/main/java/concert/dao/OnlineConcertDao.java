package concert.dao;


import concert.dto.Concert;
import concert.dto.Reservation;
import concert.dto.ReservationInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by dudin on 29/04/17.
 */
@Named
public class OnlineConcertDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Concert> getSchedule() {
        String query = "SELECT concerts.concert_id, concerts.performer, concerts.location, concerts.spending_time, concerts.spending_time,concerts.coast_ticket, concerts.amount_ticket " +
                "FROM concerts ORDER BY concerts.spending_time;";


        List<Concert> raspisanie = jdbcTemplate.query(query, (rs, rowNum) -> {
            Concert concert = new Concert();
            concert.setConcertId(rs.getInt("concert_id"));
            concert.setPerformer(rs.getString("performer"));
            concert.setLocation(rs.getString("location"));
            concert.setSpendingTime(rs.getDate("spending_time").toLocalDate());
            concert.setCoastTicket(rs.getInt("coast_ticket"));
            concert.setAmountTicket(rs.getInt("amount_ticket"));
            return concert;
        });

        return raspisanie;
    }

    public void addReservation(Reservation reservation) {
        String insertQuery = "INSERT INTO reservation(customer_data, concert_id, count_tickets) VALUES(?, ?, ?) ;";
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement(insertQuery);
                    ps.setString(1, reservation.getCustomerData());
                    ps.setInt(2, reservation.getConcertId());
                    ps.setInt(3, reservation.getCountTickets());
                    return ps;
                });

    }


    public ReservationInfo getReservationInfo(int reservation_id) {

        String selectQuery = "SELECT customer_data, performer, location, spending_time, count_tickets" +
                " FROM reservation JOIN concerts ON reservation.concert_id = concerts.concert_id" +
                " WHERE reservation_id = ? ;";
        ReservationInfo info = jdbcTemplate.queryForObject(selectQuery, new RowMapper<ReservationInfo>() {
            @Override
            public ReservationInfo mapRow(ResultSet rs, int i) throws SQLException {
                return new ReservationInfo(rs.getString("customer_data"), rs.getString("performer"), rs.getString("location"), rs.getDate("spending_time").toLocalDate(), rs.getInt("count_tickets"));
            }
        }, reservation_id);
        return info;
    }


    public boolean deleteBooking(int bookingCode) {
        String deleteQuery = "DELETE FROM reservation WHERE reservation_id LIKE ? ;";
        int affectedRowsNumber = jdbcTemplate.update(deleteQuery, bookingCode);
        if (affectedRowsNumber == 0) {
            return false;
        }
        return true;
    }

}
