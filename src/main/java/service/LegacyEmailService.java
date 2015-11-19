package service;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by roof on 11/18/15.
 */
public class LegacyEmailService {
    private static String USER_NAME = "massive.mail3r@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "N0mif00rA"; // GMail password
    private static String RECIPIENT = "roofimon@gmail.com";
    private GenericMailSession session;
    String from = USER_NAME;
    String pass = PASSWORD;

    public void setSession(GenericMailSession session) {
        this.session = session;
    }

    public void send(String[] args) {
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Your transaction is completed !!!";
        try {
            MimeMessage message = new MimeMessage(session.getSession());
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];
            getInternetAddress(to, toAddress);
            addRecipient(message, toAddress);
            message.setSubject(subject);
            message.setText(body);

            session.send(message);
        }
        catch (AddressException ae) {
            ae.printStackTrace();
        }
        catch (MessagingException me) {
            me.printStackTrace();
        }
    }




    private void addRecipient(MimeMessage message, InternetAddress[] toAddress) throws MessagingException {
        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }
    }

    private void getInternetAddress(String[] to, InternetAddress[] toAddress) throws AddressException {
        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }
    }
}
