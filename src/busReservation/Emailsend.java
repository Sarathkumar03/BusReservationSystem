package busReservation;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class Emailsend {

    public Emailsend(Booking booking)
    {
        // Email ID of the recipient
        String recipient = booking.getEmail();

        System.out.println("Preparing to send mail to " + recipient);

        // Email configuration
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Sender email credentials (use environment variables for security)
        String username = "sarathselvi32165@gmail.com"; // Replace with your email ID
        String password = "cycs jpru efrw vphz";       // Replace with your password or App Password

        // Validate that credentials are set
        if (username == null || password == null) {
            System.out.println("Email credentials are not set.");
            return;
        }

        // Authenticate and create session
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Prepare and send the email
            Message message = prepareMessage(session, username, recipient,booking);
            Transport.send(message);
            System.out.println("Email sent successfully to " + recipient);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to send the email.");
        }
    }
    private static Message prepareMessage(Session session, String username, String recipient,Booking booking ) throws MessagingException {
        // Create a simple email message
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        message.setSubject("Test Email");
        message.setText("Hello "+booking.getPassengerName() + " successfully booked bus Number: "+booking.getBusNo()+" on "+ booking.getDate()+
                " thank you for booking");
        return message;
    }

}
