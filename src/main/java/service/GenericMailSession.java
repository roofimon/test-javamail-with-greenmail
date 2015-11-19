package service;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by roofimon on 11/19/2015 AD.
 */
public class GenericMailSession {
    private Session session;
    private String USER_NAME = "massive.mail3r@gmail.com";  // GMail user name (just the part before "@gmail.com")
    private String PASSWORD = "N0mif00rA"; // GMail password
    String from = USER_NAME;
    String pass = PASSWORD;
    Properties props;
    String host;
    int port;

    public GenericMailSession() {
        props = System.getProperties();
    }

    public void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(host, port, from, pass);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public Session getSession(){
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        session = Session.getDefaultInstance(props);
        return session;
    }
}
