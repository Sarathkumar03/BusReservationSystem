package busReservation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.*;

public class BookingDAO {
    public int getbookCount(int busNo,Date date) throws SQLException {
        String query="select count(passanger_name) from  booking where bus_no=? and travel_date=?";
        Connection con=DBconnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        pst.setInt(1,busNo);
        pst.setDate(2,sqlDate);
        ResultSet rs=pst.executeQuery();
        rs.next();
        return rs.getInt(1);

    }
    public void addBooking(Booking booking) throws SQLException
    {
        String query="Insert booking values(?,?,?)";
        Connection con=DBconnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        pst.setString(1,booking.passangerName);
        pst.setInt(2,booking.busNo);
        java.sql.Date sqlDate=new java.sql.Date(booking.date.getTime());
        pst.setDate(3,sqlDate);
        pst.executeUpdate();



    }

}
