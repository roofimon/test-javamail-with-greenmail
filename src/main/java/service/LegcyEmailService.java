package service;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
/**
 * Created by roof on 11/18/15.
 */
public class LegcyEmailService {
    private static String USER_NAME = "*****";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "********"; // GMail password
    private static String RECIPIENT = "lizard.bill@myschool.edu";

    public void send(String[] args) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = { RECIPIENT }; // list of recipient email addresses
        String subject = "Java send mail example";
        String body = "Welcome to JavaMail!";

        GmailSession gmailSession = new GmailSession(from, pass).invoke();
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

    private class GmailSession {
        private String from;
        private String pass;
        private String host;
        private Session session;

        public GmailSession(String from, String pass) {
            this.from = from;
            this.pass = pass;
        }

        public String getHost() {
            return host;
        }

        public Session getSession() {
            return session;
        }

        public GmailSession invoke() {
            Properties props = System.getProperties();
            host = "smtp.gmail.com";
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.user", from);
            props.put("mail.smtp.password", pass);
            props.put("mail.smtp.port", "587");
            props.put("mail.smtp.auth", "true");
            session = Session.getDefaultInstance(props);
            return this;
        }
    }
}
