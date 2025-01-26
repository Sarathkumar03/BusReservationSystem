package busReservation;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;
import java.text.SimpleDateFormat;
public class Booking {
    String passangerName;
    int busNo;
    Date date;
    Booking()
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name of passenger:");
        passangerName=sc.nextLine();
        System.out.println("enter bus number:");
        busNo=sc.nextInt();
        System.out.println("enter date dd-MM-yyyy:");
        String dateInput=sc.next();
        SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAvailable() throws SQLException {
        BusDAO busDAO=new BusDAO();
        BookingDAO bookingDAO=new BookingDAO();
        int capacity=busDAO.getCapacity(busNo);

        int booked=bookingDAO.getbookCount(busNo,date);

        return booked<capacity?true:false;
    }


}
