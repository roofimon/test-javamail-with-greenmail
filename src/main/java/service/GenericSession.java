package service;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by roof on 11/18/15.
 */
public class GenericSession {
    protected String username;
    protected String password;
    protected String host;
    protected Session session;
    protected Properties props;
    protected int port = 587;

    public GenericSession() {
        props = System.getProperties();
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.aut", "true");
    }

    public void send(MimeMessage message) throws MessagingException {
        Transport transport = session.getTransport("smtp");
        transport.connect(host, port, username, password);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public MimeMessage getMimeMessage(String to, String subject, String body) throws MessagingException {
        MimeMessage message = new MimeMessage(this.session);
        message.setFrom(new InternetAddress(this.username));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(body);
        return message;
    }

    public GenericSession invoke() {
        session = Session.getDefaultInstance(props);
        return this;
    }
}
