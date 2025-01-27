package busReservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class busdemo {
    public static void main(String[] args)  {
        /*ArrayList<bus> buses=new ArrayList<bus>();
        ArrayList<Booking> Bookings=new ArrayList<Booking>();


        buses.add(new bus(1,true,2));
        buses.add(new bus(2,true,54));
        buses.add(new bus(3,false,54));
        buses.add(new bus(4,true,54));
        buses.add(new bus(5,false,54));

         */

        try {
            BusDAO busDAO=new BusDAO();
            busDAO.displayBusInfo();

            int userOpt=1;
            Scanner sc=new Scanner(System.in);


            while(userOpt == 1){
                System.out.println("Enter 1 to book and 2 to exit");
                userOpt=sc.nextInt();
                if(userOpt == 1){
                    Booking booking=new Booking();
                    if(booking.isAvailable())
                    {
                        BookingDAO bookingDAO=new BookingDAO();
                        bookingDAO.addBooking(booking);
                        Emailsend emailsend=new Emailsend(booking);

                        System.out.println("your booking is confirm");
                    }
                    else {
                        System.out.println("sorry bus is full try another date or bus");
                    }

                }
            }

        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
