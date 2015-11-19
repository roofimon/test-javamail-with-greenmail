package service;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by roof on 11/18/15.
 */
public class LegcyEmailService {
    private String from = "massive.mail3r@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private String pass = "N0mif00rA"; // GMail password
    private GmailSession gmailSession;

    public void setGmailSession(GmailSession session) {
        this.gmailSession = session;
    }

    public void send(String[] args) {
        String[] to = args; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        Session session = gmailSession.getSession();
        String host = gmailSession.getHost();

        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            getRecipientInternetAddress(to, toAddress);
            addRecipientToMessage(message, toAddress);
            message.setSubject(subject);
            message.setText(body);

            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }

    private static void addRecipientToMessage(MimeMessage message, InternetAddress[] toAddress) throws MessagingException {
        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
    }

    private static void getRecipientInternetAddress(String[] to, InternetAddress[] toAddress) throws AddressException {
        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }
    }

}
