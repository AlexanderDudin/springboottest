package concert.dto;

import java.sql.*;
import java.time.LocalDate;

/**
 * Created by dudin on 28/04/17.
 */
public class ConcertMySQLDB {
    public static final String INSERT_INTO_CONCERTS =
            "INSERT  INTO  concerts(performer, location, spending_time, coast_ticket, amount_ticket)" +
                    " VALUES  (?,?,?,?,?)";

    static Connection concertConn = null;
    static PreparedStatement concertPrepareStat = null;

    public static void main(String[] argv) {

        try {
            log("-------- Start ------------");
            makeJDBCConnection();

            log("\n---------- Adding concerts to DB ----------");
            addDataToDB("Linkin Park", "Minsk,Belarus", LocalDate.parse("2015-08-26"), 50, 5000);
            addDataToDB("Limp Bizkit", "Paris,France", LocalDate.parse("2015-08-27"), 40, 9000);
            addDataToDB("Aria", "Moscow,Rusiian", LocalDate.parse("2015-08-28"), 20, 3000);

            log("\n---------- Let's get Data from DB ----------");
            getDataFromDB();

            concertPrepareStat.close();
            concertConn.close(); // connection close

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    private static void makeJDBCConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            log("Congrats - Seems your MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            log("Sorry, couldn't found JDBC driver. Make sure you have added JDBC Maven Dependency Correctly");
            e.printStackTrace();
            return;
        }

        try {
            // DriverManager: The basic service for managing a set of JDBC drivers.
            concertConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concertdb", "root", "root");
            if (concertConn != null) {
                log("Connection Successful! Enjoy. Now it's time to push data");
            } else {
                log("Failed to make connection!");
            }
        } catch (SQLException e) {
            log("MySQL Connection Failed!");
            e.printStackTrace();
            return;
        }

    }

    private static void addDataToDB(String performer, String location, LocalDate spendingTime, int coastTicket, int amountTicket) {

        try {
            String insertQueryStatement = INSERT_INTO_CONCERTS;

            concertPrepareStat = concertConn.prepareStatement(insertQueryStatement);
            concertPrepareStat.setString(1, performer);
            concertPrepareStat.setString(2, location);
            concertPrepareStat.setDate(3, java.sql.Date.valueOf(spendingTime));
            concertPrepareStat.setInt(4, coastTicket);
            concertPrepareStat.setInt(5, amountTicket);

            // execute insert SQL statement
            concertPrepareStat.executeUpdate();
            log(performer + " added successfully");
        } catch (

                SQLException e) {
            e.printStackTrace();
        }
    }

    private static void getDataFromDB() {

        try {
            // MySQL Select Query Tutorial
            String getQueryStatement = "SELECT * FROM concerts";

            concertPrepareStat = concertConn.prepareStatement(getQueryStatement);

            // Execute the Query, and get a java ResultSet
            ResultSet rs = concertPrepareStat.executeQuery();

            // Let's iterate through the java ResultSet
            while (rs.next()) {
                String performer = rs.getString("performer");
                String location = rs.getString("location");
                Date spendingTime = rs.getDate("spending_time");
                int coastTicket = rs.getInt("coast_ticket");
                int amountTicket = rs.getInt("amount_ticket");

                // Simply Print the results
                System.out.format("%s, %s, %s, %s, %s\n", performer, location, spendingTime, coastTicket, amountTicket);
            }

        } catch (

                SQLException e) {
            e.printStackTrace();
        }

    }

    // Simple log utility
    private static void log(String string) {
        System.out.println(string);

    }
}
